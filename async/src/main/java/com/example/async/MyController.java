package com.example.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MyController {
    @Autowired
    private AsyncTaskService asyncTask;
    @RequestMapping("/test")
    public void test() throws InterruptedException{
//        asyncTask.executeAsyncTask();
    }
}
