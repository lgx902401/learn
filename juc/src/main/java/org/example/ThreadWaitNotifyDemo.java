package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：现在两个线程，可以操作一个初始值为零的变量
 * 实现一个线程对该变量加一，一个线程对该变量减一
 * 实现交替，来十轮，变量初始值为零。
 * <p>
 * 1.高聚低合前提下，线程操作资源类。
 * 2.判断/干活/通知
 * 3.多线程交互中，防止线程的虚假唤醒，也即（判断只用while，不能用if）
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class AirConditioner {//资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //新版本
    public void increment() throws InterruptedException{
        lock.lock();
        try {
            //1.判断
            while (number != 0) {
                condition.await();//this.wait()
            }
            //2.干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.通知
            condition.signalAll();//this.notifyAll()
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement() throws InterruptedException{
        lock.lock();
        try {
            //1.判断
            while (number == 0) {
                condition.await();//this.wait()
            }
            //2.干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.通知
            condition.signalAll();//this.notifyAll()
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //老版本
//    public synchronized void increment() throws InterruptedException {
//        //1.判断
//        while (number != 0) {
//            this.wait();
//        }
//        //2.干活
//        number++;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        //3.通知
//        this.notifyAll();
//    }
//
//    public synchronized void decrement() throws InterruptedException {
//        //1.判断
//        while (number == 0) {
//            this.wait();
//        }
//        //2.干活
//        number--;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        //3.通知
//        this.notifyAll();
//    }
}