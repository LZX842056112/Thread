package com.itcast.demo2;

/**
 * 静态代理模式
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 * 好处：代理对象可以做很多真实对象做不了的事情，真实对象专注做自己的事情
 */
public class StacticProxy {

    public static void main(String[] args) {
        Person person = new Person();

//        WeddingCompany company = new WeddingCompany(person);
//        company.HappyMarry();

        new WeddingCompany(new Person()).HappyMarry();

        new Thread(()-> System.out.println("我爱你")).start();
    }

}

//结婚
interface Marry{
    void HappyMarry();
}

//真实角色，去结婚
class Person implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("结婚开心");
    }
}
//代理角色，婚庆公司
class WeddingCompany implements Marry{

    private Marry target;
    //真实角色=>代理对象
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//真实角色
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置场地");
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }
}