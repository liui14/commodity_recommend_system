package com.recommend.service.email.impl;

import com.recommend.domain.vo.EmailVO;
import com.recommend.interceptor.RequestHolder;
import com.recommend.service.email.EmailService;
import com.recommend.util.CommonsUtil;
import com.recommend.util.EmailUtil;
import com.recommend.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;


@Slf4j
public class RedisEmailService implements EmailService {

    private final EmailUtil emailUtil;

    private final RedisUtil redisUtil;


    public RedisEmailService(EmailUtil emailUtil, RedisUtil redisUtil) {
        this.emailUtil = emailUtil;
        this.redisUtil = redisUtil;
    }

    @Override
    public EmailVO create(String toEMail) throws IOException {
        log.info("toEmail: {}",toEMail);
        String token = CommonsUtil.getToken();
        log.info("token: {}", token);
        String code = EmailUtil.generateCode();
        log.info("code: {}", code);
        boolean result = emailUtil.sendVerificationCode(toEMail, code);
        if (result) {
            redisUtil.set(toEMail, code, 5);
            return null;
        }
        return null;
    }

    @Override
    public Boolean verify(String email,String verCode) {
        if(email == null || verCode == null) {
            return false;
        }
        Object code;
        code = redisUtil.get(email);
        code = code == null ? null : code.toString();

        if(code == null){
            return false;
        }
        return code.equals(verCode);
    }
}
