package com.jack.juc.test2;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/13
 * @Description :
 **/
public class Demo01{
    /**
     * 0:开,1:关
     */
    private Integer num = 0;

    Object key = new Object();

    /**
     * 开灯
     */
    public synchronized void on() throws InterruptedException {
        Thread.sleep(1000);
        while (num > 0){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+" : 开灯 : "+num);
        this.notify();
    }

    /**
     * 关灯
     */
    public synchronized void off() throws InterruptedException {
        Thread.sleep(1000);
        while (num <= 0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+" : 关灯 : "+num);
        this.notify();
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    demo01.on();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    demo01.off();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
