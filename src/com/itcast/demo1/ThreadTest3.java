package com.itcast.demo1;

/**
 * @author LiZongXiao
 * @create 2020/6/1 21:19
 */
//创建线程方式2：实现Runnable接口，重写run方法，执行线程需要丢入Runnable接口实现类，调用start方法
public class ThreadTest3 implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("run方法........."+i);
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        ThreadTest3 threadTest3 = new ThreadTest3();
        //创建线程对象，通过线程对象开启我们的线程代理
        new Thread(threadTest3).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main方法........."+i);
        }
    }
}
