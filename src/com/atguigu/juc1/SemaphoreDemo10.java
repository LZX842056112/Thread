package com.atguigu.juc1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 在信号量上我们定义两种操作：
 * acquire(获取)当一个线程调用acquire操作时，他要么通过成功获取信号量（信号量减1），
 *          要么一直等待下去，直到有线程释放信号量，或超时。
 * release(释放)实际上会将信号量加1，然后唤醒等待的线程。
 *
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制
 */
public class SemaphoreDemo10 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟资源类，有3个空车位
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到了车位");
                    //暂停一会线程
                    try {TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
