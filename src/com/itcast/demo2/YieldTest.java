package com.itcast.demo2;

public class YieldTest {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"A").start();
        new Thread(myYield,"B").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        Thread.yield();//线程礼让
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
}