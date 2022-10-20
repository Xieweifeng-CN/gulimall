package com.jack.juc.test4;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/14
 * @Description :
 **/
public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //4846841196
        ForkJoin forkJoin = new ForkJoin(1L, 98456L);
        ForkJoinTask<BigDecimal> forkJoinTask = forkJoinPool.submit(forkJoin);
        BigDecimal result = forkJoinTask.get();
        System.out.println(result);
    }

}
