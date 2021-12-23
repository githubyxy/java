package multithreading.commonSynchronizerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yuxiaoyu
 * @date 2021/12/23 上午10:50
 * @Description
 */
public class FutureTaskTest {
    // 定义一个线程池
    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    public static void main(String[] args) {
        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            // 将每个sheet提交到线程池
            Future<Integer> submit = executor.submit(new SheetThread(i));

            list.add(submit);
        }

        Integer total = 0;
        for (Future<Integer> future : list) {
            try {
                // 阻塞获取所有线程的执行结果
                total += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("excel总行数为：" + total + "行");

        executor.shutdown();
    }

    /**
     * 模拟统计sheet行数的线程类
     */
    public static class SheetThread implements Callable<Integer> {

        private Integer sheetIndex;

        public SheetThread(int sheetIndex) {
            this.sheetIndex = sheetIndex;
        }

        public Integer call() {
            int i = (int) (Math.random() * 100);
            try {
                System.out.println(Thread.currentThread().getName() + "启动了，时间为" + System.currentTimeMillis());
                Thread.sleep(1000); //模拟任务执行耗时
                System.out.println(Thread.currentThread().getName() + "执行完了，时间为" + System.currentTimeMillis() + " sheet" + sheetIndex + "的行数为：" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        }
    }
}
