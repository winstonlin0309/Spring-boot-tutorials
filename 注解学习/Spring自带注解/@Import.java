
/*
 * 介绍:
 *      - 当我们自己配置类(@Configuration)的时候, 我们需要把配资料加载到IoC 容器\
 *          这就会导致我们需要加载很多个 比如:
 *          ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationA.class, ConfigurationB.class, .... );
 *      - 但是如果使用了@Import, 我们就可以在每一个class中上面引用需要的配置类
 *      - 

 */

//Class A
 @Configuration
public class ConfigA {

  @Bean
  public A a() {
    return new A();
  }
}

//Class B
@Configuration
@Import(ConfigA.class)
public class ConfigB {

  @Bean
  public B b() {
    return new B();
  }
}

//这是就只需要放进一个配置到IoC容器就行 
ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigB.class);