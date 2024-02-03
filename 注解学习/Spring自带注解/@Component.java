/*
 * 介绍：
 *      - @Component, @Repository, @Service, @Cntroller这四个注解的作用其实都是一样的， 只是给我们人看的时候比较清楚
 *      - 用于Spring 中的Bean， 它是一个泛化的概念，仅仅表示容器中的一个组件(Bean)，并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。 使用时只需将该注解标注在相应类上即可。
 *      - 用于普通层的定义
 *      - 将类标识为Spring中的Bean
 */

 @Component(value = "user")     //这就是类似于 <bean id="user" class = "..."        这个默认值可以不写， 那就会是class名字的小写
 public class User{

 } 