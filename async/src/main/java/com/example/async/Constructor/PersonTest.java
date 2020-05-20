package com.example.async.Constructor;

/**
 * 一、构造器的作用：
 * 1.创建对象
 * 2.初始化对象的信息
 *
 * 二、说明：
 * 1.如果没有显式定义类的构造器的话，则系统默认提供一个空参构造器
 * 2.定义构造器的格式：权限修饰符 类名（形参列表）{}
 * 3.一个类中定义多个构造器，彼此构成重载
 * 4.一旦我们显示定义类的构造器，系统就不再提供默认的空参构造器
 */
public class PersonTest {
    public static void main(String[] args) {
//        Person p = new Person();
//        p.eat();
        Person p1 = new Person("tom");
        System.out.println("*******************");
//        Student student = new Student("1");
    }

}

class Person {
    //属性
    String name;
    int age;

    //构造器
    public Person() {
        System.out.println("Person()....");
    }

    public Person(String n) {
        this();
        name = n;
    }

    //方法
    public void eat() {
        System.out.println("eat。。。。");
    }
}

class Student extends Person{
    public Student() {
        System.out.println("student");
    }

    public Student(String n) {
    }

    public void eat() {
        System.out.println("eat。。。。");
    }

}