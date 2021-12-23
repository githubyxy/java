package multithreading.commonSynchronizerUtils;

import java.util.concurrent.Semaphore;

/**
 * @author yuxiaoyu
 * @date 2021/12/21 上午11:48
 * @Description
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);

        Runnable runnable = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "获得了信号量>>>>>,时间为" + System.currentTimeMillis());
                Thread.sleep(1000);
          System.out.println(Thread.currentThread().getName() + "释放了信号量<<<<<,时间为" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++)
            threads[i] = new Thread(runnable);
        for (int i = 0; i < threads.length; i++)
            threads[i].start();
    }
}
