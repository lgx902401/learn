package com.example.async.AbstractDemo;

/**
 * abstract关键字的使用
 * 1.abstract：抽象的
 * 2.abstract可以用来修饰结构、类、方法
 *
 * 3.abstract修饰类,抽象类
 *     子类不可以实例化
 *     抽象类中一定有构造器，便于子类实例化使用（涉及，子类对象实例化过程）
 *     开发中，都会提供抽象类的子类，让子类对象实例化，完成相关操作
 *
 * 4.abstract修饰方法，抽象方法
 *     抽象方法只有方法的声明，没有方法体
 *     包含抽象方法的类，y一定是一个抽象类。反之，抽象类中可以没有抽象方法。
 */
public class AbstractTest {
    public static void main(String[] args) {
        //一旦Personl类抽象了，就不可以实例化
//        Person p = new Person();
//        p.walk();
        Student student = new Student();
        student.walk();
    }
}

abstract class Person{
    String name ;
    int age;

    public Person(){
        System.out.println("person");
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //这个不是抽象方法
//    public void eat(){
//    }
    //抽象方法
    public abstract void eat();

    public void walk(){
        System.out.println("walk");
    }
}
class Student extends Person{
    public Student(){

    }
    @Override
    public void eat() {
        System.out.println("Student eat");
    }
}