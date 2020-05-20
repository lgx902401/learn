package com.example.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    private Logger logger = LoggerFactory.getLogger(AsyncTaskService.class);
    /**
     * @Description:通过@Async注解表明该方法是一个异步方法，
     * 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAysncTask1
     * @Date: 2018年9月21日 下午2:54:32
     * @Author: OnlyMate
     * @Throws
     * @param i
     */
    @Async
    public void executeAysncTask1(Integer i){
        String uuId = UUIDUtil.getUniqueIdByUUId();
        logger.info("执行异步任务", i);
    }

    /**
     * @Description:通过@Async注解表明该方法是一个异步方法，
     * 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAsyncTask2
     * @Date: 2018年9月21日 下午2:55:04
     * @Author: OnlyMate
     * @Throws
     * @param i
     */
    @Async
    public void executeAsyncTask2(Integer i){
        logger.info("CustomMultiThreadingService ==> executeAsyncTask2 method: 执行异步任务{} ", i);
    }
//    @Async
//    public void task1() throws InterruptedException{
//        System.out.println("开始执行task1");
//        long start = System.currentTimeMillis();
//        Thread.sleep(2000);
//        long end = System.currentTimeMillis();
//        System.out.println("task1耗时："+(end-start)+"毫秒");
//    }
//    @Async
//    public void task2() throws InterruptedException{
//        System.out.println("开始执行task2");
//        long start = System.currentTimeMillis();
//        Thread.sleep(2000);
//        long end = System.currentTimeMillis();
//        System.out.println("task2耗时："+(end-start)+"毫秒");
//    }
//    @Async
//    public void task3() throws InterruptedException{
//        System.out.println("开始执行task3");
//        long start = System.currentTimeMillis();
//        Thread.sleep(2000);
//        long end = System.currentTimeMillis();
//        System.out.println("task3耗时："+(end-start)+"毫秒");
//    }
}
