package multithreading.commonSynchronizerUtils;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest extends Thread {
    private CyclicBarrier cb;
    private int sleepSecond;

    public CyclicBarrierTest(CyclicBarrier cb, int sleepSecond) {
        this.cb = cb;
        this.sleepSecond = sleepSecond;
    }

    public void run() {
        try {
            System.out.println(this.getName() + "开始, 时间为" + System.currentTimeMillis());
            Thread.sleep(sleepSecond * 1000);
            cb.await();
            System.out.println(this.getName() + "结束, 时间为" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("CyclicBarrier的barrierAction开始运行, 时间为" + System.currentTimeMillis());
            }
        };
        CyclicBarrier cb = new CyclicBarrier(2, runnable);
        for (int i=0; i<2; i++) {
            CyclicBarrierTest cbt0 = new CyclicBarrierTest(cb, 3);
            CyclicBarrierTest cbt1 = new CyclicBarrierTest(cb, 6);
            cbt0.start();
            cbt1.start();

            System.out.println("_____________________________________");
        }
    }

}
