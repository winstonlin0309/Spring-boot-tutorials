 

// TODO: 增强方法中获取目标方法信息
// 1. 全部增强方法中, 获取目标方法的信息(方法名, 参数, 访问修饰符, 所属的类的信息)
//     - 在parameter里面定义一个 JoinPoint joinPoint的参数
//     - joinPoint 里面就有目标方法的信息
// 2. 获取返回的结果 - @AfterReturning
// 3. 获取异常信息 - @AfterThrowing

package com.atguigu.advice;

/*
    定义四个增强方法, 获取目标方法的信息, 返回值 以及异常对象

    1. 定义方法 - 增强代码
    2. 使用住家指定对应的位置
    3. 配置切点表达式选中方法
    4. 切面和ico的配置
    5. 开启aspectj注解的支持

    TODO: 增强方法中获取目标方法信息
        1. 全部增强方法中, 获取目标方法的信息(方法名, 参数, 访问修饰符, 所属的类的信息)
            - 在parameter里面定义一个 JoinPoint joinPoint的参数
            - joinPoint 里面就有目标方法的信息
        2. 获取返回的结果 - @AfterReturning
            - (Object result) result接收返回结果
            - @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "param_name")
        3. 获取异常信息 - @AfterThrowing
            - (Throwable t) t来接收异常信息
            - @AfterThrowing(value = "execution(* com..impl.*.*(..))", throwing="throwable") 
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@EnableAspectJAutoProxy
public class MyAdvice {

    @Before("execution(* com..impl.*.*(..))")
    public void start(JoinPoint joinPoint) {
        //1. 获取方法属于的类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        
        //2. 获取方法名称
        String name = joinPoint.getSignature().getName();

        //3. 获取参数列表
        Object[] args = joinPoint.getArgs();

    }

    @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "result")      //把返回的结果放到一个名为 result的变量
    public void afterReturning(JoinPoint joinPoint, Object result) {        //这个result 转载着上面的返回结果, 变量名必须和上面一样

    }

    @After()
    public void after() {

    }

    @AfterThrowing(value = "execution(* com..impl.*.*(..))", throwing="throwable")
    public void afterThrow(JoinPoint joinPoint, Throwable throwable) {

    }


}
