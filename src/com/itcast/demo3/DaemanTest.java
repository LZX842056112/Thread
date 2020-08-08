package com.itcast.demo3;

//守护线程
public class DaemanTest {
    public static void main(String[] args) {
        God god = new God();
        Person person = new Person();

        Thread thread = new Thread(god);
        //默认是false表示用户线程，正常线程都是用户线程
        thread.setDaemon(true);
        //神护线程启动
        thread.start();
        //用户线程启动
        new Thread(person).start();
    }
}

//神
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("神保佑你");
        }
    }
}

//人
class Person implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("一生都开心地活着"+i);
        }
        System.out.println("====goodbye!====");
    }
}