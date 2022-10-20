package com.jack.juc.test3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/14
 * @Description :
 **/
public class Demo01 {

    private Integer num = 0;

    private ReentrantLock lock = new ReentrantLock();

    public void on(){
        lock.lock();
        try {
            Thread.sleep(1000);
            if (num > 0){
                System.out.println("开灯中");
            }
            System.out.println(Thread.currentThread().getName()+" : 开灯");
            num++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void off(){
        lock.lock();
        try {
            Thread.sleep(1000);
            if (num <= 0){
                System.out.println("关灯中");
            }
            System.out.println(Thread.currentThread().getName()+" : 关灯");
            num--;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();

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
