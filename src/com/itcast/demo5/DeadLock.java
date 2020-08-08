package com.itcast.demo5;

/**
 * 死锁：多个线程互相抱着对方需要的资源，然后形成僵持
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup m1 = new Makeup(0,"张三");
        Makeup m2 = new Makeup(1,"李四");

        m1.start();
        m2.start();
    }
}
//镜子
class Mirror{
}
//口红
class Lipstick{
}

class Makeup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //使用化妆品的人
    String name;

    public Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(this.name+"获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(this.name+"获得镜子的锁");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.name+"获得镜子的锁");
                Thread.sleep(1000);
            }
            synchronized (lipstick){
                System.out.println(this.name+"获得口红的锁");
            }
        }
    }
}
