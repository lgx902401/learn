package com.example.async.Polymorphism;

import java.sql.Connection;

//多态性的使用举例一
public class AnimalTest {

    public static void main(String[] args) {
        AnimalTest animalTest = new AnimalTest();
        animalTest.func(new Dog());
        animalTest.func(new Cat());
    }

    public void func(Animal animal){//Animal animal = new Dog();
        animal.eat();
        animal.shout();
    }

//    public void func(Dog dog){
//        dog.eat();
//        dog.shout();
//    }
//
//    public void func(Cat cat){
//        cat.eat();
//        cat.shout();
//    }
}
class Animal{

    public void eat(){
        System.out.println("动物：吃");
    }
    public void shout(){
        System.out.println("动物：叫");
    }
}

class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");

    }

    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
}
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");

    }

    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }
}

//举例二
class Order{
    public void method(Object obj){

    }
}

//举例三
class Driver{
    public void doData(Connection conn){//conn = new MySQLConnection(); /conn = new OracleConnection();
        //规范的步骤操作数据
        //conn.method1():
        //conn.method2():
        //conn.method3():

    }
}