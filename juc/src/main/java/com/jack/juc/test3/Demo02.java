package com.jack.juc.test3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/14
 * @Description :
 **/
public class Demo02 {

    private Integer num = 0;

    private ReentrantLock lock = new ReentrantLock();

    public void on(){
        boolean b = false;
        lock.lock();
        try {
            Thread.sleep(1000);
            b = lock.tryLock();
            if (b){
                if (num <= 0){
                    System.out.println(Thread.currentThread().getName()+" : 开灯");
                    num++;
                }
            }else {
                System.out.println("等待");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void off(){
        boolean b = false;
        lock.lock();
        try {
            Thread.sleep(1000);
            b = lock.tryLock();
            if (b){
                if (num > 0){
                    System.out.println(Thread.currentThread().getName()+" : 关灯");
                    num--;
                }else {
                    System.out.println("");
                }
            }else {
                System.out.println("等待");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Demo02 demo01 = new Demo02();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                demo01.on();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                demo01.off();
            }
        }).start();
    }

}
