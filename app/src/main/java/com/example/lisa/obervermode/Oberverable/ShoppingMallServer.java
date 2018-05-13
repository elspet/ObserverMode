package com.example.lisa.obervermode.Oberverable;

import com.example.lisa.obervermode.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 被观察者
 */
public class ShoppingMallServer implements Observerable {

    List<Observer> observers;
    boolean priceCut = false;
    float currentPrice = 0f;

    public ShoppingMallServer(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!observers.isEmpty())
            observers.remove(observer);
    }

    @Override
    public void notifyObserver() {

        for (int i=0;i<observers.size();i++){
            observers.get(i).update(priceCut,currentPrice);
        }

    }

    // 数据发生变动，通知观察者
    public void changePrice(boolean priceCut,float currentPrice){
        this.priceCut = priceCut;
        this.currentPrice = currentPrice;
        notifyObserver();
    }
}
