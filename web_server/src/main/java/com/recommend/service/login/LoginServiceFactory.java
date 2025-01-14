package com.recommend.service.login;

import com.recommend.service.login.impl.LocalLoginService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

public class LoginServiceFactory {

    @ConditionalOnProperty(name = {"oppf.cache-support"}, havingValue = "local", matchIfMissing = true)
    @Bean
    public LocalLoginService cacheLoginService() {
        return new LocalLoginService();
    }
}
