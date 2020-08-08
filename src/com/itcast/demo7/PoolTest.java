package com.itcast.demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class PoolTest {
    public static void main(String[] args) {
        //1.创建服务。创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //2.执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //3.关闭连接
        service.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}