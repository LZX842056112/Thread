package com.itcast.demo2;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class SleepTest2 {
    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num < 0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        //打印当前时间
        Date startTime = new Date(System.currentTimeMillis());//获取系统当前时间
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());//更新当前时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        try {
//            tenDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
