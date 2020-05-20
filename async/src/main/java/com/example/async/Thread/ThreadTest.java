package com.example.async.Thread;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run()
 * 3. 创建Thread类的子类对象
 * 4. 通过此对象调用start()
 *
 * 例子：遍历100以内所有的偶数
 *
 * Created by Lam on 2020/5/12 12:52
 */



class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        //通过此对象调用start()：①启动当前线程 ②调用当前线程的run()
        t1.start();
        //问题一：不能直接调用run()的方式启动线程。
//        t1.run();
        //问题二：不能让已经start()的的线程去执行。IllegalThreadStateException
//        t1.start();
        //需要重新创建一个线程对象
        MyThread t2 = new MyThread();
        t2.start();
    }
}