package com.itcast.demo6;

/**
 * 生产者消费者模型-->利用缓冲区解决：管程法
 * 生产者，消费者，产品，缓冲区
 */
public class PCTest {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }
    //生产
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }
    //消费
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("消费了"+ container.pop().id+"只鸡");
        }
    }
}
//产品
class Chicken{
    //产品编号
    int id;
    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContainer{
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，就等待消费者消费
        if (count == chickens.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没满，就继续放入容器中
        chickens[count++] = chicken;
        //可以通知消费者消费了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //如果容器空了，就等待生产者生产
        if (count == 0){
            //通知生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果容器没空，就继续从容器中消费
        Chicken chicken = chickens[--count];
        //可以通知生产者生产了
        this.notifyAll();

        return chicken;
    }
}