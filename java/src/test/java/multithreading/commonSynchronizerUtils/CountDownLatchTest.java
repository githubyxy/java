package multithreading.commonSynchronizerUtils;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static class WorkThread extends Thread {
        private CountDownLatch cdl;

        public WorkThread(String name, CountDownLatch cdl) {
            super(name);
            this.cdl = cdl;
        }

        public void run() {
            System.out.println(this.getName() + "启动了，时间为" + System.currentTimeMillis());
            System.out.println(this.getName() + "我要统计每个sheet的行数");
            try {
                cdl.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + "执行完了，时间为" + System.currentTimeMillis());
        }
    }

    private static class sheetThread extends Thread {
        private CountDownLatch cdl;

        public sheetThread(String name, CountDownLatch cdl) {
            super(name);
            this.cdl = cdl;
        }

        public void run() {
            try {
                System.out.println(this.getName() + "启动了，时间为" + System.currentTimeMillis());
                Thread.sleep(1000); //模拟任务执行耗时
                cdl.countDown();
                System.out.println(this.getName() + "执行完了，时间为" + System.currentTimeMillis() + " sheet的行数为：" + (int) (Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(2);

        WorkThread wt0 = new WorkThread("WorkThread", cdl );
        wt0.start();

        sheetThread dt0 = new sheetThread("sheetThread1", cdl);
        sheetThread dt1 = new sheetThread("sheetThread2", cdl);
        dt0.start();
        dt1.start();

    }
}
