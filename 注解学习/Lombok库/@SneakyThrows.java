/*
 * 介绍：
 *      -  @SneakyThrows 是 Lombok（一种 Java 库）提供的注解之一。它的主要作用是简化异常处理的代码。
 *      - 在 Java 中，如果一个方法可能会抛出受检异常（checked exception），那么你必须在方法的声明中使用 throws 关键字来声明这些异常，
 *          或者在方法内部使用 try-catch 块来捕获和处理这些异常。这样的代码通常会增加冗余和复杂性。
            Lombok 的 @SneakyThrows 注解可以应用在方法上，它告诉编译器自动生成异常处理代码，从而简化了异常处理。使用这个注解后，你可以在方法内部抛出受检异常，而不需要显式地声明或捕获它们
    使用方式：
        - 在method上
 */

 import lombok.SneakyThrows;

public class Example {
    @SneakyThrows
    public void myMethod() {
        throw new Exception("This is a checked exception");
        int i = 1;
        System.out.println();
    }
    
}
