package com.jack.juc.test1;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/13
 * @Description :
 **/
public class Demo01 extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Thread线程执行");
    }

    public static void main(String[] args) {
        new Demo01().start();
    }
}
