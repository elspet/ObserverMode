# ObserverPattern
设计模式之观察者模式

在对象间建立一个一对多的依赖关系，当特定对象发生变化时，其他对象将收到通知并自动更新

模式组成：
+ 1、抽象观察者
+ 2、抽象被观察者
+ 3、观察者
+ 4、被观察者

#### 一、抽象观察者
```java 
    // 接收到观察到的消息，做更新
    void update(boolean priceCut,float currPrice);
```

#### 二、抽象被观察者
```java
    // 注册观察者
    void registerObserver(Observer observer);
    // 移除观察者
    void removeObserver(Observer observer);
    // 通知观察者
    void notifyObserver();
```

#### 三、观察者
```java
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

```

#### 四、被观察者
```java
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

```

#### 五、测试调用
```java
    User userAnn = new User("Ann");
    ShoppingMallServer server = new ShoppingMallServer();
    // 注册观察者
    server.registerObserver(userAnn);
    // 价格发生变动
    server.changePrice(true,999);
    // 移除观察者
    server.removeObserver(userAnn);
```


