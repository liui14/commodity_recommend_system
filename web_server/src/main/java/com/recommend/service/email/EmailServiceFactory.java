package com.recommend.service.email;

import com.recommend.service.email.impl.LocalEmailService;
import com.recommend.service.email.impl.RedisEmailService;
import com.recommend.service.verify.impl.LocalVerifyService;
import com.recommend.util.EmailUtil;
import com.recommend.util.RedisUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceFactory {

    @Bean
    @ConditionalOnProperty(name = {"settings.cache-support"}, havingValue = "local", matchIfMissing = true)
    public LocalEmailService localEmailService() {
        return new LocalEmailService();
    }

    @Bean
    @ConditionalOnProperty(name = {"settings.cache-support"}, havingValue = "redis", matchIfMissing = true)
    public RedisEmailService reidsEmailService(RedisUtil redisUtil, EmailUtil emailUtil) {
        return new RedisEmailService(emailUtil,redisUtil);
    }
}
