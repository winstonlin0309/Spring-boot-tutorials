package com.atguigu.advice;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/*
    1. 定义方法存储增强代码
        具体定义几个犯法, 根据插入的位置决定
    2. 使用注解配置 指定插入目标方法的位置
        前置  @Before
        后置  @AfterReturning
        异常  @AfterThrowing
        最后  @After
        环绕  @Around
    3. 配置切点表达式[选中插入的方法  切点]
    4. 补全注解
        加入ico容器 @Component
        配置切面    @Aspect = 切点 + 增强

    5. 开启Aspect注解的支持
        1. 通过注解: @EnableAspectJAutoProxy
        2. 通过xml: 通过添加 <aop:aspectj-autoproxy /> 在xml中
 */

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAdvice {
    /*
        TODO: 切点表达式
            固定语法: execution(1 2 3.4.5(6))
            1. 访问修饰符
                public / private
            2. 方法的返回参数类型
                String int void
              如果不考虑访问修饰符和返回值! 这两位整合成一个 *, 不能出现 * String 或者 public *, 这俩要么都写 要么就整合成*
            3. 包的位置
                具体包: com.atguigu.service.impl
                单层模糊: com.atguigu.service.*     //单层下面的任意包都行
                多层模糊: com..impl        任意层的下面的名为impl的包
                注意: ..不能为开头
            4. 类的名称
                具体: CalculatorPureImpl
                模糊: *
                部分模糊: *Impl     //以Impl结尾的类
            5. 方法名 语法和类名一致
            6. (6)值的是参数列表
                没有参数:()
                有具体参数: (String)  (String, int)   //注意 顺序是有要求的
                模糊参数: (..) 有没有参数都可以, 有多个也可以
                部分模糊: (String..) String 后面有没有无所谓
                        (..int) 最后一个参数是int的
                        (String..int)   开始为String, 中间无所谓, 结尾是int


        TODO: 实战
            1. 查询某包某类下, 访问修饰符是共有的, 返回值是int的全部方法
                execution(public int xx..jj.*(..))
            2. 查询某包下类中第一个参数是String的方法
                execution(* xx.jj.*(String..))
            3.查询全部包下，无参数的方法！
                execution(* *..*.*())
            4.查询com包下，以int参数类型结尾的方法
                execution(* com..*.*(..int))
            5.查询指定包下，Service开头类的私有返回值int的无参数方法
                execution(public int xx.Service.*())

     */



    @Before("execution(* com.atguigu.service.impl.*.*(..))")
    public void start() {
        System.out.println("方法开始");
    }

    @After("execution(* com.atguigu.service.impl.*.*(..))")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.atguigu.service.impl.*.*(..))")
    public void error() {
        System.out.println("方法报错了");
    }

}
