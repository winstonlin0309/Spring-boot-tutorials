/*
介绍：
    - AspectJ是一个AOP的思想的一种实现， 本质上是静态代理， 但是通过将代理
      逻辑织被代理的目标变异得到的字节码文件， Spring只是借用了AspjectJ中的注解
    - 简单来说就是通过 @Aspect注解来开启/完成AOP的运作
使用方式：
    - 一般跟着Component一起用， 用在类上面
*/

//切面类
@Aspect //切面类
@Component  //ioc容器
public class LogAspect {

    //设置切入点和通知类型
    /*切入点表达式： execution(public int <package-path-includes-class_name> <想要使用的类中的method的名称> <parameter>)
        public int:
            - 如果替换成* 就是所有类型      ？？？
        <package-path-includes-class_name>
            - 如果把class_name换成* 就是该package中的所有类
        <想要使用的类中的method的名称>: 比如说类是 Calculator， 里面的Method有 add(), sub() mul() div()
            - * 代表全部class
        <parameter>
            - 你需要传进来的参数
            - *(..) 代表你想要传进来的全部参数
    */
    //通知类型： 前置通知， 返回通知， 异常通知， 后置通知， 环绕通知

    @Before()     //前置通知
    @AfterReturning     //返回通知
    @AfterThrowing      //异常通知
    @After()            //后置通知
    @Around()       //环绕通知      //包括以上所有， 甚至更细节

    
    //@Before(value = "切入点表达式配置切入点")
    @Before(value="excution(public int com.atguigu.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod() {
    
    }

    @After(JoinPoint joinPoint) {
        String methodName = joinPoint.getStignature().getName();
    }

    

}