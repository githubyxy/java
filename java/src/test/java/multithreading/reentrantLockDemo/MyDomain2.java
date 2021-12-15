package multithreading.reentrantLockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDomain2 {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void await() {
        System.out.println("进入await方法");
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " conditionA await " + System.currentTimeMillis());
            conditionA.await();
            System.out.println(Thread.currentThread().getName() + " conditionA await out " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void await2() {
        System.out.println("进入await2方法");
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " conditionB await " + System.currentTimeMillis());
            conditionA.await();
            System.out.println(Thread.currentThread().getName() + " conditionB await out " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        System.out.println("进入signal方法");
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " conditionA signal " + System.currentTimeMillis());
            conditionA.signalAll();
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " conditionA signal " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll2() {
        System.out.println("进入signalAll2方法");
        try {
            lock.lock();
            conditionB.signalAll();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " conditionB signalAll2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
