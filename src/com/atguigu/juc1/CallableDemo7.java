package com.atguigu.juc1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("******come in call method()");
        try {
            TimeUnit.SECONDS.sleep(2 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1080;
    }
}

/**
 * 多线程中，第3种获得多线程的方式
 *      1.get方法一般放在最后一行
 */
public class CallableDemo7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread2());

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        System.out.println(Thread.currentThread().getName()+"******计算完成");

        Integer result = futureTask.get();
        System.out.println(result);
    }
}