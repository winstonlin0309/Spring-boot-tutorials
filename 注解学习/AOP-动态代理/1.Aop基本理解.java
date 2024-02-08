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

 @Component     //得先放到IoC容器里
 @Aspect        //指定这个类为 切面对象
 @EnableAspectJAutoProxy        //允许引用AspectJ的注解, 因为AspectJ是第三方, 所以需要给权限
 public class LogAdvice {
 
     @Before("execution(* com.atguigu.service.impl.*.*(..))")           // 先要对其进行面向切面对象的类的路径
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
