package multithreading.threadsignalDemo;

public class MyThread1_1 extends Thread {

    private Object lock;

    public MyThread1_1(Object lock) {
        this.lock = lock;
    }

    public void run() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "开始------wait time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println(Thread.currentThread().getName() + "开始------sleep time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "结束------sleep time = " + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + "结束------wait time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
