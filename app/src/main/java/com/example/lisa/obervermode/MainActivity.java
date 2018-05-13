package com.example.lisa.obervermode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lisa.obervermode.Oberverable.ShoppingMallServer;
import com.example.lisa.obervermode.Observer.User;

public class MainActivity extends AppCompatActivity {

    User userLisa;
    User userAnn;
    ShoppingMallServer server;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userLisa = new User("Lisa");
        userAnn = new User("Ann");
        server = new ShoppingMallServer();
        testObserverMode();
    }

    /**
     * TODO 测试观察者模式
     */
    private void testObserverMode(){

        server.registerObserver(userLisa);
        server.registerObserver(userAnn);
        Log.d("observer", "--");

        // 价格发生变动
        server.changePrice(false,1100);
        // 价格又发生变动
        server.changePrice(true,999);
    }


}
