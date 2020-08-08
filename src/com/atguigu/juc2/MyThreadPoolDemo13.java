package com.atguigu.juc2;

import java.util.concurrent.*;

public class MyThreadPoolDemo13 {
    public static void main(String[] args) {
        //CPU
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors()+1,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            //模拟有10个顾客过来办理业务，目前池子里有5个工作人员提供服务
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static void initPool() {
        //一个池子有5个工作线程，类似银行有5个受理窗口
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一个池子有1个工作线程，类似银行有1个受理窗口
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //一个池子有n个工作线程，类似银行有n个受理窗口
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            //模拟有10个顾客过来办理业务，目前池子里有5个工作人员提供服务
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
                //暂停毫秒
                //try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
