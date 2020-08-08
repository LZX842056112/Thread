package com.itcast.demo2;

/**
 * 总结：
 *  3.Lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
 *  2.前提是接口为函数式接口（只包含唯一一个抽象方法）
 *  1.多个参数也可以去多参数类型，要去掉就都去掉，必须加上括号
 *
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        //Lambda表达式
        ILove love = (int a)->{
            System.out.println("I Love1 "+a);
        };

        //1.简化去掉参数类型
        love = (a)->{
            System.out.println("I Love2 "+a);
        };

        //2.简化参数括号
        love = a->{
            System.out.println("I Love3 "+a);
            System.out.println("I Love33 "+a);
        };

        //3.简化花括号
        love = a-> System.out.println("I Love4 "+a);

        love.love(521);
    }
}

interface ILove{
    void love(int a);
}