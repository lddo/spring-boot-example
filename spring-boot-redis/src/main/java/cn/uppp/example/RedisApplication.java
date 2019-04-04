package cn.uppp.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 应用入口
 * @MapperScan 扫描mapper文件对应接口
 * @EnableCaching 启用缓存
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.uppp.example.dao")
@EnableCaching
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
