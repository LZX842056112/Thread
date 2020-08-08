package com.atguigu.juc1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类 = 实例变量 + 实例方法
class Ticket{
    //票
    private int number = 30;
    Lock lock  = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 *题目：三个售票员   卖出   30张票
 * 笔记：如何编写企业级的多线程
 * 固定的编程套路+模板
 * 1.在高内聚低耦合的前提下，线程    操作(对外暴露的调用方法)     资源类
 *  1.1先创建一个资源类
 */
public class SaleTicketDemo1 {
    //主线程，一切程序的入口
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //新版写法
        new Thread(()->{for (int i = 1; i <= 40; i++) ticket.sale();},"A").start();
        new Thread(()->{for (int i = 1; i <= 40; i++) ticket.sale();},"B").start();
        new Thread(()->{for (int i = 1; i <= 40; i++) ticket.sale();},"C").start();
    }
}