package com.example.async.Thread;

/**
 * 例子：创建三个窗口卖票，总票数100张，实现Runnable接口方式
 *
 * 问题：卖票过程中，出现重票，错票-->出现线程的安全问题
 * 问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
 * 如何解决：在Java中，我们通过同步机制。
 *
 * 方法一：同步代码块
 * synchronized(同步监视器){
 *      //需要同步的代码
 * }
 * 说明：1.操作共享数据的代码，即为需要被同步的代码。
 *      2.共享数据：多个线程共同操作的变量。
 *      3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 *          要求：多个线程必须共用一把锁。
 *       补充：在实现Runnable接口创建多线程的方式中，可以考虑使用this充当监视器
 * 方法二：同步方法
 *
 * 5.同步的方式，解决了线程的安全问题。--好处
 *              操作同步代码时，只能有一个线程参与，其他等待，相当于一个当线程的过程，效率低。---局限性
 *
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w2 = new Window2();

        Thread t1 = new Thread(w2);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }



}

class Window2 implements Runnable{
    private int ticket = 100;
//    Object object = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized(this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }

            }
        }
    }
}