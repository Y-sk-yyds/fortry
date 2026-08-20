package com.example.fortry.other;

import java.util.LinkedList;
import java.util.Queue;

class MyBlockingQueue<T>{
    Queue<T> queue=new LinkedList<>();

    private int maxSize;


    public MyBlockingQueue(int maxSize){
        this.maxSize=maxSize;
    }

    public synchronized void put(T item) throws InterruptedException{
        while(queue.size()==maxSize){
            System.out.println("full! "+Thread.currentThread().getName()+" 当前大小为: "+queue.size());
            this.wait();
        }
        queue.add(item);
        System.out.println(Thread.currentThread().getName()+"生产了： "+item+" 当前大小为："+queue.size());
        this.notifyAll();
    }

    public synchronized T take() throws InterruptedException{
        while(queue.isEmpty()){
            System.out.println(Thread.currentThread().getName()+" 等待空");
            this.wait();
        }
        T item=queue.poll();
        System.out.println(Thread.currentThread().getName()+"消费了： "+item+" 现在大小是： "+queue.size());
        this.notifyAll();
        return item;
    }
}

public class ProducerComsumerDemo {
    public static void main(String[] args){
        MyBlockingQueue<Integer> queue=new MyBlockingQueue<>(3);

        Thread producer1=new Thread(()->{
            for(int i=1;i<11;i++){
                try {
                    queue.put(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"producer1");

        Thread consumer1=new Thread(()->{
            for(int i=1;i<11;i++){
                try {
                    queue.take();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"consumer1");

        Thread consumer2=new Thread(()->{
            for(int i=1;i<11;i++){
                try {
                    queue.take();
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"consumer2");

        producer1.start();
        consumer1.start();
        consumer2.start();
    }


}
