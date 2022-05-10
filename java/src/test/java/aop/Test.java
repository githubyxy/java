package aop;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuxiaoyu
 * @date 2022/4/29 下午3:55
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class Test {

    @Autowired
    private AopTest aopTest;

    @org.junit.Test
    public  void test() {

        System.out.println("开始测试");
        try {

            aopTest.test();
        } catch (Exception e) {
            System.out.println("yyyyyy");
        }
        System.out.println("执行完成");
    }
}
