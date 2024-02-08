/*
 * 介绍:
 *      如何声明配置类
 *          @Configuration
 *      如何扫描包注解
 *          @ComponentScan("com.atguigu")
 *      如何引用外部配置
 *          @@PropertySource("classpath:jdbc.properties")
 *      如何声明bean
 *          @Bean
 * 
 * 使用配置类对应的容器也变了,
 *      - 之前是 ClassPathXmlApplicationContext
 *      - 现在是 AnnotationConfigApplicationContext
 */

@Configuration
public class Student {

    
}