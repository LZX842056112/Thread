package com.itcast.demo2;

import com.itcast.demo1.ThreadTest4;

//模拟网络延时，放大问题的发生性
public class SleepTest implements Runnable{
    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }
            try {
                //模拟延时
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //拿到线程名字
            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        SleepTest SleepTest = new SleepTest();
        new Thread(SleepTest,"小明").start();
        new Thread(SleepTest,"老师").start();
        new Thread(SleepTest,"黄牛").start();
    }
}
