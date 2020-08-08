package com.itcast.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//练习，多线程同步下载图片
public class ThreadTest2 extends Thread {

    private String url;//图片下载的地址
    private String name;//保存的文件名

    public ThreadTest2( String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片的执行体
    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("下载了图片名为"+name);
    }

    public static void main(String[] args) {
        ThreadTest2 t1 = new ThreadTest2("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","1.jpg");
        ThreadTest2 t2 = new ThreadTest2("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","2.jpg");
        ThreadTest2 t3 = new ThreadTest2("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png","3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}
//下载器
class WebDownLoader{
    //下载方法
   public void downloader(String url,String name){
       try {
           //url变成文件
           FileUtils.copyURLToFile(new URL(url),new File(name));
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("IO异常，downloader方法出现问题");
       }
   }
}