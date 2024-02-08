/*
 * 环绕通知就融合了前面所有的单个通知
 */

 package com.atguigu.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {

    /*
        环绕通知, 需要你在通知中, 定义目标方法的执行

        @param proceedingJoinPoint 目标方法(获取目标方法信息, 多了一个执行方法)
        @return 目标方法的返回值
     */

    @Around("com.atguigu.pointcut.MyPointcut.pc()")
    public Object transaction(ProceedingJoinPoint proceedingJoinPoint){

        //保证目标方法被执行即可
        Object[] args = proceedingJoinPoint.getArgs();      //必须得
        Object result = null;


        //这里try catch最好要加, 不然会报错, 因为没有办法得到throwable的rollback的信息
        try {
            //增强代码 -> 类似之前的 @Before
            System.out.println("开启事务");
            result = proceedingJoinPoint.proceed(args);     //反射
            System.out.println("结束事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        }
        return result;
    }
}
