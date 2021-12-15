package multithreading.synchronizedDemo;

/**
 * 测试count 实例变量 共享问题
 *
 * @author yuxiaoyu
 */
public class Mythread16 extends Thread {

    private MyDomain16 myDomain16;

    public Mythread16(MyDomain16 myDomain16) {
        this.myDomain16 = myDomain16;
    }

    public void run() {
        myDomain16.count();
    }


}
