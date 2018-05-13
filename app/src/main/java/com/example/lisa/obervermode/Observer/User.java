package com.example.lisa.obervermode.Observer;

import android.util.Log;

/**
 * TODO 观察者
 */
public class User implements Observer {

    String userName="";

    public User(String name){
        this.userName = name;
    }

    @Override
    public void update(boolean priceCut, float currPrice) {

        if (priceCut) {
            Log.d("observer", userName+": 我喜欢的鞋子降价啦，当前价格：¥" + currPrice+"，老公你要给我买吗？");
        }else {
            Log.d("observer", userName+": 我喜欢的鞋子涨价啦，当前价格：¥" + currPrice+"，买不起买不起");
        }
    }


}
