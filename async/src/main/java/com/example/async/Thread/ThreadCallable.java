package com.example.async.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口
 *
 * Created by Lam on 2020/5/14 17:30
 */

//1.创建一个实现Callable的实现类
class NewThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum +=i;
            }
        }
        return sum;
    }
}
public class ThreadCallable {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NewThread newThread = new NewThread();
        //4.将Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(newThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            Object o = futureTask.get();
            System.out.println("总和："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
