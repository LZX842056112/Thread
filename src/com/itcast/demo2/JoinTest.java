package com.itcast.demo2;

//测试join方法，插队
public class JoinTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println("线程vip..."+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
        Thread thread = new Thread(joinTest);
        thread.start();

        for (int i = 0; i <= 50; i++) {
            if (i == 30){
                thread.join();//插队
            }
            System.out.println("main"+i);
        }
    }
}
