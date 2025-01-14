package com.recommend.service.verify;

import com.recommend.service.verify.impl.LocalVerifyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

public class VerifyServiceFactory {
    @Bean
    @ConditionalOnProperty(name = {"oppf.cache-support"}, havingValue = "local", matchIfMissing = true)
    public LocalVerifyService cacheVerifyService() {
        return new LocalVerifyService();
    }
}
