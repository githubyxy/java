package multithreading.commonSynchronizerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yuxiaoyu
 * @date 2021/12/23 下午12:19
 * @Description
 */
public class CompletableFutureTest {
    // 定义一个线程池
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 2; i++) {
            // 将每个sheet提交到线程池
            CompletableFuture completableFuture = new CompletableFuture();
            executor.submit(new SheetThread(i, completableFuture));

            System.out.println("excel总行数为：" + completableFuture.get() + "行");

            int finalI = i;
            completableFuture.supplyAsync(() -> new SheetThread(finalI, completableFuture), executor);
        }

        executor.shutdown();
    }

    /**
     * 模拟统计sheet行数的线程类
     */
    public static class SheetThread implements Runnable {

        private Integer sheetIndex;
        private CompletableFuture completableFuture;

        public SheetThread(int sheetIndex, CompletableFuture completableFuture) {
            this.sheetIndex = sheetIndex;
            this.completableFuture = completableFuture;
        }

        public void run() {
            int i = (int) (Math.random() * 100);
            try {
                System.out.println(Thread.currentThread().getName() + "启动了，时间为" + System.currentTimeMillis());
                Thread.sleep(1000); //模拟任务执行耗时
                System.out.println(Thread.currentThread().getName() + "执行完了，时间为" + System.currentTimeMillis() + " sheet" + sheetIndex + "的行数为：" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete(i);
        }
    }
}
