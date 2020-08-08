package com.itcast.demo1;

/**
 * 创建线程方式：继承Thread，重写run()方法，调用()开启线程
 * 注意，线程开启不一定立即执行，由CPU调度执行
 */
public class ThreadTest1 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("run方法........."+i);
        }
    }

    public static void main(String[] args) {
        //main主线程
        //创建线程对象
        ThreadTest1 threadTest1 = new ThreadTest1();
        //start开启线程
        threadTest1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main方法........."+i);
        }
    }
}
