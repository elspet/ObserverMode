package com.example.lisa.obervermode.Observer;

/**
 * TODO 抽象观察者
 */
public interface Observer {

    // 接收到观察到的消息，做更新
    void update(boolean priceCut,float currPrice);
}
