package com.itcast.demo4;

/**
 * 2.不安全取钱
 */
public class UnSafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"结婚基金");

        Drawing boy = new Drawing(account,50,"男孩");
        Drawing girl = new Drawing(account,100,"女孩");

        boy.start();
        girl.start();
    }
}
//账户
class Account{
    int money;//金额
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//银行
class Drawing extends Thread{
    //账户
    Account account;
    //取了多少钱
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    //synchronized 默认锁的是this
    @Override
    public void run() {
        //锁的对象就是变化的量，需要增删改查的量
        synchronized (account){
            //判断有没有钱
            if (account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额 = 余额 - 取的钱
            account.money = account.money - drawingMoney;
            //手里的钱
            nowMoney += drawingMoney;

            System.out.println(account.name+"余额为："+account.money);
            //Thread.currentThread().getName() = this..getName()
            System.out.println(this.getName()+"手里的钱"+nowMoney);
        }
    }
}