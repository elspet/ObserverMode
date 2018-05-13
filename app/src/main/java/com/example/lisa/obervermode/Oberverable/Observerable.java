package com.example.lisa.obervermode.Oberverable;

import com.example.lisa.obervermode.Observer.Observer;

/**
 * TODO 抽象被观察者
 */
public interface Observerable {

    // 注册观察者
    void registerObserver(Observer observer);
    // 移除观察者
    void removeObserver(Observer observer);
    // 通知观察者
    void notifyObserver();
}
