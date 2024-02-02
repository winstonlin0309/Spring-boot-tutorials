/* 
    介绍：
        - @Slf4j 注解会自动在类中生成一个名为 log 的私有静态字段，该字段可以用来记录日志
        - 在软件开发中起到了非常重要的作用，它们是为了记录应用程序的运行时信息和事件，以便在需要时进行故障排查、监控、性能优化和调试
   
    使用方式：
        - 在class上
*/

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyLoggerExample {
    public void doSomething() {
        log.info("This is an informational log message.");
    }
}
