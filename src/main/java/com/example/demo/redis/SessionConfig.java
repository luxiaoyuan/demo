package com.example.demo.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=86400*30)
public class SessionConfig 
{
    /**
     * maxInactiveIntervalInSeconds:设置session的生效时间，使用Redis session之后 原boot的server.session.tomeout属性不再生效
     */
}
