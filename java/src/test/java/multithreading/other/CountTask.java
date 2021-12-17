package multithreading.other;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author yuxiaoyu
 * @date 2021/12/17 下午2:02
 * @Description
 */
public class CountTask extends RecursiveTask<Integer> {
    // 阈值，设置每个子任务将执行多少计算任务
    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start > THRESHOLD) {
            int mid = (start + end) / THRESHOLD;
            CountTask leftTask = new CountTask(start, mid);
            CountTask rightTask = new CountTask(mid + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 获取子任务执行结果
            Integer leftSum = leftTask.join();
            Integer rightSum = rightTask.join();
            sum = leftSum + rightSum;

        } else {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 5);

        ForkJoinTask<Integer> submit = forkJoinPool.submit(countTask);

        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
