/*
       TODO: 切点表达式的提取和复用
            1. 当前类中提取     (不推荐)
                定义一个空方法 (必须是public void)
                注解 @Pointcut()
                增强注解中引用切点表达式的方法即可   直接调用方法名
            2. 创建一个存储切点的类     (推荐)
                单独维护切点表达式
                其他类的切点方法 类的全限定符号.方法名()
     */


     @Before("com.atguigu.pointcut.MyPointcut.pc()")
     public void start() {
         System.out.println("方法开始");
     }
 
     @After("com.atguigu.pointcut.MyPointcut.pc()")
     public void after() {
         System.out.println("方法结束了");
     }
 
     @AfterThrowing("com.atguigu.pointcut.MyPointcut.pc()")
     public void error() {
         System.out.println("方法报错了");
     }
 


    
     package com.atguigu.pointcut;

    import org.aspectj.lang.annotation.Pointcut;
    import org.springframework.stereotype.Component;

    @Component
    public class MyPointcut {
        @Pointcut("execution(* com.atguigu.service.impl.*.*(..))")
        public void pc() {}

        @Pointcut("execution(* com..impl.*.*(..))")
        public void myPc() {}
    }
