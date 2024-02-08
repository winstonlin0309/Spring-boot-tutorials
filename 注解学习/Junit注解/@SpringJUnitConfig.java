/*
 * 介绍:
 *      - 简化了 
 *           AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfig.class);

                //获取组件
                A bean = applicationContext.getBean(A.class);

                applicationContext.close();
            的整个过程

 */

 @SpringJUnitConfig(locations = "xxx.xml")    //指定配置文件xml

 @SpringJUnitConfig(value = JavaConfig.class)  //指定配置类
public class SpringIoCTest {
    
    @Autowired
    private Student student;        //直接获取组件, 不需要在A bean = applicationContext.getBean(A.class);


    @Test
    
    
}
