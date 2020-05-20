package com.example.async.Thread;

/**
 * 例子：创建三个窗口卖票，总票数100张,继承Thread
 *
 * Created by Lam on 2020/5/13 10:55
 */
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.start();
        w2.start();
        w3.start();
    }
}
class Window extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0) {
                System.out.println(getName()+":卖票，票号为"+ticket);
                ticket--;
            }else {
                break;
            }

        }
    }
}