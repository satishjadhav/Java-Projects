package com.core.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<E> {

    private int max;
    private Queue<E> queue = new LinkedList<E>();
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public CustomBlockingQueue(int size) {
        queue = new LinkedList<E>();
        this.max = size;
    }

    public void put(E e) {
        lock.lock();
        try {
            if(queue.size() == max) {
                notFull.wait();
            }
            queue.add(e);
            notEmpty.signalAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            if(queue.size() == 0) {
                notEmpty.wait();
            }
            E item = queue.remove();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
