package com.recommend.service.verify;

import com.recommend.service.verify.impl.LocalVerifyService;
import com.recommend.service.verify.impl.RedisVerifyService;
import com.recommend.util.RedisUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class VerifyServiceFactory {
    @Bean
    @ConditionalOnProperty(name = {"settings.cache-support"}, havingValue = "local", matchIfMissing = true)
    public LocalVerifyService localVerifyService() {
        return new LocalVerifyService();
    }

    @Bean
    @ConditionalOnProperty(name = {"settings.cache-support"}, havingValue = "redis")
    public RedisVerifyService redisVerifyService(RedisUtil redisUtil) {
        return new RedisVerifyService(redisUtil);
    }
}
