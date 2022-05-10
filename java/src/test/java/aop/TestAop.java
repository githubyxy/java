package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yuxiaoyu
 * @date 2022/4/29 下午3:53
 * @Description
 */
@Aspect
@Component
public class TestAop {

    /**
     * 定义切入点
     */
    @Pointcut("execution(* *.test(..))")
    public void pointCut(){}

//    @Before("pointCut()")
//    public void beforeTest() {
//        System.out.println("beforeTest");
//    }
//
//    @After("pointCut()")
//    public void afterTest() {
//        System.out.println("afterTest");
//    }
//
//    @Around("pointCut()")
//    public Object arountTest(ProceedingJoinPoint proceedingJoinPoint) {
//        System.out.println("before1");
//        Object o = null;
//        try {
//            o = proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println("after1");
//        return o;
//    }

    @AfterThrowing(value = "pointCut()", throwing = "throwable")
    public void afterthrow(Throwable throwable) {
        System.out.println("AfterThrowing");
    }

}
