package com.recommend.service.login;

import com.recommend.service.login.impl.LocalLoginService;
import com.recommend.service.login.impl.RedisLoginService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceFactory {

    @ConditionalOnProperty(name = {"settings.cache-support"}, havingValue = "local", matchIfMissing = true)
    @Bean
    public LocalLoginService localLoginService() {
        return new LocalLoginService();
    }

    @ConditionalOnProperty(name = {"settings.cache-support"}, havingValue = "redis", matchIfMissing = true)
    @Bean
    public RedisLoginService redisLoginService() {
        return new RedisLoginService();
    }
}
