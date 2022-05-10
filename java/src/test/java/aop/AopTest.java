package aop;

import org.springframework.stereotype.Component;

/**
 * @author yuxiaoyu
 * @date 2022/4/29 下午3:38
 * @Description
 */
@Component
public class AopTest {

        private String testStr = "testStr";

        public String getTestStr() {
            return testStr;
        }

        public void setTestStr(String testStr) {
            this.testStr = testStr;
        }

        public void test() {
            System.out.println("test");
            System.out.println(1/0);
            System.out.println("test complete");
        }

}
