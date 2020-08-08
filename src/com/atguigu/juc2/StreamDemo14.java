package com.atguigu.juc2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class User{
    private Integer id;
    private String userName;
    private int age;

    public User(Integer id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/**
 * 题目：请按照给出数据，找出同时满足
 *      偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 *      最后只输出一个用户名字
 */
public class StreamDemo14 {
    public static void main(String[] args) {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream().filter(u -> {
            return u.getId() % 2 == 0;
        }).filter(u -> {
            return u.getAge() > 24;
        }).map(m -> {
            return m.getUserName().toUpperCase();
        }).sorted(((o1, o2) -> {
            return o2.compareTo(o1);
        })).limit(1).forEach(System.out::println);


        List<Integer> list2 = Arrays.asList(1,2,3);
        list2 = list2.stream().map(x -> {return x * 2;}).collect(Collectors.toList());
        for (Integer element : list2) {
            System.out.println(element);
        }
/*
        //函数型接口
        Function<String,Integer> function = s -> {return s.length();};
        System.out.println(function.apply("abc"));
        //断定型接口
        Predicate<String> predicate = s -> {return s.isEmpty();};
        System.out.println(predicate.test("张三"));
        //消费型接口
        Consumer<String> consumer = s -> { System.out.println(s);};
        consumer.accept("李四");
        //供给型接口
        Supplier<String> supplier = () -> {return "王五";};
        System.out.println(supplier.get());
*/
    }
}

interface MyInterface{
    public int myInt(int x);
    public String myString(String str);
    public boolean isOK(String str);
}