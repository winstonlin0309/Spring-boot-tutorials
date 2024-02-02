/*
 * 介绍：
 *      - ThreadLocal 主要用于解决线程安全性问题以及在多线程环境下共享数据的问题
 *      - ThreadLocal 是 Java 中的一个类，用于在多线程环境下存储和访问线程本地（Thread-local）变量
 * 
 * 使用方法：
 *      - 创建一个 ThreadLocal 变量，通常使用 ThreadLocal 的子类 InheritableThreadLocal 来创建，以便子线程可以继承父线程的变量。
            使用 set() 方法在当前线程中设置变量的值。
            使用 get() 方法在当前线程中获取变量的值。
            在不再需要时，使用 remove() 方法清理线程本地变量，以防止内存泄漏。
    
    优势：
        - 线程安全的数据存储： ThreadLocal 允许每个线程存储自己的数据，而无需担心线程之间的竞争条件。
        - 上下文传递： 在多线程环境中，可以将一些上下文信息（如用户身份、事务状态等）存储在 ThreadLocal 中，
            以便线程在执行任务时可以轻松访问这些信息，而不需要显式传递它们作为参数。
        - 线程封闭（Thread Confinement）： ThreadLocal 可以用于将对象封闭在特定线程中，确保只有该线程可以访问和修改对象。
 */

 
 
//使用ThreadLocal的例子
 public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        new Thread(() -> {      //创建一个线程
            System.out.println("Thread A initial value: " + threadLocalValue.get());
            threadLocalValue.set(2);
            System.out.println("Thread A updated value: " + threadLocalValue.get());
        }).start();

        new Thread(() -> {  ////创建另一个线程
            try {
                Thread.sleep(100); // Ensure Thread A updates the value first
                System.out.println("Thread B initial value: " + threadLocalValue.get());
                threadLocalValue.set(3);
                System.out.println("Thread B updated value: " + threadLocalValue.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}








//不使用ThreadLocal的例子
public class NonThreadLocalExample {
    private static Integer sharedValue = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Thread A initial value: " + sharedValue);
            sharedValue = 2;
            System.out.println("Thread A updated value: " + sharedValue);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100); // Ensure Thread A updates the value first
                System.out.println("Thread B initial value: " + sharedValue);
                sharedValue = 3;
                System.out.println("Thread B updated value: " + sharedValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
