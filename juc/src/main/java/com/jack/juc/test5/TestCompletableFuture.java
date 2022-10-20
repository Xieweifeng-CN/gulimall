package com.jack.juc.test5;

import com.sun.xml.internal.ws.util.CompletedFuture;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author :Jack
 * @CreatTime : 2022/10/17
 * @Description :
 **/
public class TestCompletableFuture {

    /**
     * CompletableFuture链式线程,一个线程接一个线程
     * 初始线程:
     *      run: 无返回结果
     *      supply: 有返回结果
     * 接替线程:
     *      thenAccent: 无返回结果
     *      thenApply: 有返回结果
     * 结果合并:
     *      thenCompose: 接收前一个任务的结果
     *      thenCombine: 任务之间不传递数据,但可以通过 BiFunction 接收(合并)已有的两个任务结果
     * 收尾线程:
     *      complete: 手动完成,提前结束
     *      handle: 两个参数,一个是计算结果,一个是异常报告,根据运行情况返回其中一个结果
     * 异常处理:
     *      exceptionally: 根据前面任务的运行情况,作出异常处理
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Long productId = 1L;

        HashMap<String, Object> productMap = new HashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        /**
         * 线程一: 获取product信息
         */
        CompletableFuture<Product> completableFuture = CompletableFuture.supplyAsync(new Supplier<Product>() {
            @Override
            public Product get() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Product product = new Product();
                product.setProductId(productId);
                product.setName("拯救者游戏本");
                product.setImageId(11L);
                product.setStockId(111L);
                productMap.put("product",product);
                System.out.println(Thread.currentThread().getName()+"商品信息");
                return product;
            }
        },executorService);

        /**
         * 线程二: 根据product线程的结果,获取图片信息
         */
        completableFuture.thenAcceptAsync(new Consumer<Product>() {
            @Override
            public void accept(Product product) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"根据图片id获取图片信息");
                Long imageId = product.getImageId();
                List<String> list = new ArrayList<>();
                for (int i = 1; i <= 4; i++) {
                    list.add("图片"+i);
                }
                productMap.put("images",list);
            }
        },executorService);

        /**
         * 线程三: 根据product线程的结果,获取库存信息
         */
        completableFuture.thenAcceptAsync(new Consumer<Product>() {
            @Override
            public void accept(Product product) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"根据价格id获取价格信息");
                Long stockId = product.getStockId();
                productMap.put("stock",1000L);
            }
        },executorService);

        /**
         * 线程四: 获取商品价格
         */
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"价格8999");
                productMap.put("stock",8999D);
            }
        },executorService);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(productMap);
        
        executorService.shutdown();
    }
}
