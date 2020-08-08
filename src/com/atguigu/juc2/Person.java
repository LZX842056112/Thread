package com.atguigu.juc2;

//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@NoArgsConstrucor
//@Getter
//@Setter
public class Person {
    private Integer id;
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }
}
