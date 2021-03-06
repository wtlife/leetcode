package code.tag;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wutao
 * @version V1.0
 * @Desc Test
 * @date 2021/1/28
 */
public class Interview {


    private List<Integer> list = new LinkedList<>();
    private Integer capacity = 10;

    public static void main(String[] args) {
        Interview produceConsume = new Interview();
        new Thread(produceConsume::produce1, "produce").start();
        new Thread(produceConsume::consume1, "consume").start();


        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                8,16,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(100));
        ThreadLocal local = new ThreadLocal();
        ReentrantLock lock = new ReentrantLock();

    }


    //生产者消费者模型
    public void produce1() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            synchronized (list) {
                if (list.size() == capacity) {
                    try {
                        list.wait();
                        System.out.println("生产完毕,size: " + list.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(1);
                System.out.println("生产ing,size: " + list.size());
                //aware
                list.notifyAll();
            }
        }
    }

    public void consume1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            synchronized (list) {
                if (list.isEmpty()) {
                    try {
                        System.out.println("消费完毕,size : " + list.size());
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.remove(0);
                System.out.println("消费ing, size" + list.size());
                list.notifyAll();
            }
        }
    }

}
