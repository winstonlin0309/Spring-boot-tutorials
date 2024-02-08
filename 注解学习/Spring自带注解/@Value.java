package com.atguigu.ioc_04;

import org.springframework.beans.factory.annotation.Value;

public class JavaBean {
    /*

    <bean id class
        <preperty name="name" value="二狗子"       这里使用value就是进行直接赋值,但这个是xml的方法

     */

    /*

        用注解方法:
            方案1: 直接设, 例如 private String name = "二狗子"
            方案2: 用注解方式来赋值
                - 使用@Value()  来直接给变量赋值    不管declaration中是什么type, 在@Value() 里面只能是String

            什么情况下会使用@Value
                - 当我们需要从外部读取值的时候, 比如说从 一个叫jdbc.preperties的file里面读取值

            注意:
                当我们想要从外部文件读取值得时候,我们需要在 xml里面设置, 请看spring-04.xml


     */

    @Value("19")        //不建议, 一般都是直接赋值, 比如public String name = "hihi"     和这个效果是一样的
    private int age;

    @Value("${jdbc.username}")      //引用外部值
    private String username;

    @Value("${jdbc.password}")
    private String password;
}
