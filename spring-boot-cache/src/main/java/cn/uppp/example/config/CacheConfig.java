package cn.uppp.example.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * 缓存配置
 *
 * @EnableCaching 启用缓存
 */
@Configuration
@EnableCaching
public class CacheConfig {
    /* 存活时间 */
    private static final Duration TIME_TO_LIVE = Duration.ofSeconds(30);

    /**
     * 自定义缓存key生成策略
     *
     * @return
     */
    @Bean
    public KeyGenerator customKeyGenerator() {
        return (o, method, objects) -> {
            StringBuffer sb = new StringBuffer();
            sb.append(o.getClass().getName());
            sb.append(":");
            sb.append(method.getName());
            for (Object object : objects) {
                sb.append(":");
                sb.append(object);
            }
            return sb;
        };
    }

    /**
     * 自定义缓存序列化格式
     * 更改为JSON格式
     *
     * @return
     */
    @Bean
    public RedisCacheConfiguration customRedisCacheManager() {
        Jackson2JsonRedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        redisSerializer.setObjectMapper(objectMapper);
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .entryTtl(TIME_TO_LIVE);
    }
}
