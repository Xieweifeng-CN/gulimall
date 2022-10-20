package com.jack.juc.test1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/13
 * @Description :
 **/
public class Demo03 {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(()->{
            System.out.println("123");
            return Thread.currentThread().getName()+"线程执行了";
        });

        new Thread(futureTask,"callable").start();

        System.out.println(futureTask.get());
    }
}
