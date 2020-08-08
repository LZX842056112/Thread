package com.itcast.demo4;

/**
 * 1.不安全的买票
 * 线程不安全：有负数和重复票
 */
public class BuyTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"黄牛").start();
    }
}

class Ticket implements Runnable{
    //票
    private int ticketNums = 10;
    //外部停止方式
    boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized 同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <= 0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(10);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}