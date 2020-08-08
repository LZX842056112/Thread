package com.atguigu.juc1;

/**
 * 拷贝中括号，写死右箭头，落地大括号
 * @FunctionalInterface
 * default
 * static
 */
//显示声明函数式接口
@FunctionalInterface
interface Poo{
//    public void sayHello();
    public int add(int x,int y);
    //声明和实现
    public default int mull(int x,int y){
        return x * y;
    }

    public static int div(int x,int y){
        return x/y;
    }
}
//拷贝中括号，写死右箭头，落地大括号
public class LambdaExpressDemo2 {
    public static void main(String[] args) {
/*        Poo poo = new Poo() {
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
            @Override
            public int add(int x, int y) {
                return 0;
            }
        };
        poo.sayHello();
*/
        //Lambda
        Poo poo1 = (int x,int y)-> {
            System.out.println("add");
            return x + y;
        };
        System.out.println(poo1.add(2,3));

        System.out.println(poo1.mull(3,4));

        System.out.println(Poo.div(8,4));
    }
}
