package com.example.async.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 ---JDK5.0 新增
 *
 * 1.面试题：synchronized 与 lock的异同？
 *      同：二者都可以解决线程安全的问题。
 *      不同：synchronized机制在执行完相应的同步代码块以后，自动释放同步监视器
 *          Lock需要手动的启动同步（lock()）,同时结束同步也需要手动的实现(unlock())
 *
 *
 */

class Window4 implements Runnable{
    private int ticket = 100;

    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try{
                //2.调用锁定方法lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":卖票，票号为"+ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3.调用解锁方法：unlock()
                lock.unlock();
            }

        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window4 w = new Window4();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
