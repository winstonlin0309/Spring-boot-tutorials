/*
 * 当有两个 AOP需要对同一个目标对象执行的时候, 这时候就要考虑优先级了
 * 两个AOP都会被执行, 但是谁先执行 得通过@Order来规划
 * 
 * 优先级定义
 *      数字越小, 优先级越大, 默认是 Integer.MAX_VALUE
 */

 


 //第一个AOP
package com.atguigu.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class TxAdvice {
    //这是我们正常弄得
    @Before("com.atguigu.pointcut.MyPointcut.pc()")
    public void begin() {
        System.out.println("开启事务_order高的");
    }

    @AfterReturning("com.atguigu.pointcut.MyPointcut.pc()")
    public void commit() {
        System.out.println("事务提交_order高的");
    }

    @AfterThrowing("com.atguigu.pointcut.MyPointcut.pc()")
    public void rollback() {
        System.out.println("事务回滚_order高的");
    }
}


//第二个AOP
package com.atguigu.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(15)
public class TxAroundAdvice {

    /*
        环绕通知, 需要你在通知中, 定义目标方法的执行

        @param proceedingJoinPoint 目标方法(获取目标方法信息, 多了一个执行方法)
        @return 目标方法的返回值
     */

    @Around("com.atguigu.pointcut.MyPointcut.pc()")
    public Object transaction(ProceedingJoinPoint proceedingJoinPoint){

        //保证目标方法被执行即可
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;


        //这里try catch最好要加, 不然会报错, 因为没有办法得到throwable的rollback的信息
        try {
            //增强代码 -> 类似之前的 @Before
            System.out.println("开启事务");
            result = proceedingJoinPoint.proceed(args);
            System.out.println("结束事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        }
        return result;
    }
}


//这里就会先执行
//System.out.println("开启事务_order高的");

//然后
//System.out.println("开启事务");

//然后! 注意了, 会在执行
//System.out.println("结束事务");

//之后才会是 
//System.out.println("结束事务_order高的");

// 因为前置的 先执行, 后置的 后执行, 而他就属于后置的