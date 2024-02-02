/*
RedisTemplate
    介绍：
        - RedisTemplate 是Spring Data Redis的模块的一部分， 他提供了一种方便的方法来与Redis数据库进行交互 包括存储、检索、删除数据等操作
        

Redis （Remote Dictionary Server）
    介绍：
        -  Redis 是一种键值存储数据库，它的操作通常涉及到复杂的命令和数据序列化， RedisTemplate 封装了这些底层操作，提供了高级别的方法和抽象，
            使得在 Spring 应用中更容易进行 Redis 操作
    为什么要使用Redis
        - Redis 允许你配置持久性选项，将数据保存到磁盘上，以便在重新启动时恢复数据。这使得 Redis 可以用于长期存储数据，而不仅仅是临时缓存
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveData(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getData(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteData(String key) {
        redisTemplate.delete(key);
    }
}


/*
 * redisTemplate.opsForValue()
 */