package multithreading.synchronizedDemo;

/**
 * 测试count 实例变量 共享问题
 *
 * @author yuxiaoyu
 */
public class MyDomain16 {

    private volatile int count = 0;

    public MyDomain16() {
    }

    public synchronized void count() {
        for (int i=0; i<10000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        System.out.println(Thread.currentThread().getName() + ": count=" + count);
    }
}
