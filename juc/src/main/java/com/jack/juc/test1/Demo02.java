package com.jack.juc.test1;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/13
 * @Description :
 **/
public class Demo02 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行");
    }

    public static void main(String[] args) {
        Demo02 runnable = new Demo02();

        new Thread(runnable,"runnable线程").start();
    }

}
