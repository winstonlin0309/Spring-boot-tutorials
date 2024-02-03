/*
 * 介绍：
 *      - 当一个interface 有多个child的时候， 此时你想要注入， 你就要使用Qualifier来确认你想要的是哪个类
 * 
 * 使用：
 *      - 和@Autowired 一起用
 */


 @Autowired
 @Qualifier(value = "<class_name>")
 private User user;