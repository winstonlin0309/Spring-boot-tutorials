/*
 * 介绍：
 *      - Serializable 是为了能够把数据转序列化为字节流
 *      - 也能转换成json 以便发送http request到前端
 * 
 * 为什么要序列化为字节流
 *      - 持久性存储：将对象序列化为字节流后，可以将字节流保存到磁盘上，以便在以后从磁盘中读取并重新构建对象。这是一种常见的对象持久化方式，通常用于保存应用程序的状态或数据。
        - 数据传输：在分布式系统中，对象序列化为字节流后可以在不同的计算机或进程之间传输。这对于远程方法调用（RMI）、网络通信和消息传递等应用非常有用。
        - 跨平台兼容性：字节流是平台无关的，可以在不同的操作系统和编程语言之间共享。这意味着你可以在一个平台上序列化对象，然后在另一个平台上反序列化它，而不会受到平台差异的影响。
        - 缓存和高速缓存：字节流可以用于将对象存储在内存中的缓存中，以提高访问速度。当需要时，可以从缓存中获取字节流并将其反序列化为对象。
 */

 public static class AcceptToken implements Serializable {
    private String app = AppConstants.APP;
    private String userId;
    private Long time = System.currentTimeMillis();
    private String salt = RandomStringUtils.random(32);
}