package com.jack.juc.test4;

import java.math.BigDecimal;
import java.util.concurrent.RecursiveTask;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/14
 * @Description :
 **/
public class ForkJoin extends RecursiveTask<BigDecimal> {

    private Long begin;
    private Long end;
    public static final int RANGE = 50;
    private BigDecimal result = new BigDecimal(0);

    public ForkJoin(Long begin, Long end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected BigDecimal compute() {

        if ((end - begin) <= RANGE){
            for (Long i = begin; i <= end; i++) {
                result = result.add(new BigDecimal(i));
            }
        }else {
            Long leftBegin = begin;
            Long leftEnd = (end+begin)/2;

            Long rightBegin = leftEnd+1;
            Long rightEnd = end;

            ForkJoin node1 = new ForkJoin(leftBegin, leftEnd);
            ForkJoin node2 = new ForkJoin(rightBegin, rightEnd);

            node1.fork();
            node2.fork();

            BigDecimal result1 = node1.join();
            BigDecimal result2 = node2.join();

            result = result1.add(result2);
        }
        return result;
    }
}
