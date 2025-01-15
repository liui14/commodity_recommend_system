package com.recommend.service.email.impl;

import com.recommend.domain.vo.EmailVO;
import com.recommend.service.email.EmailService;

import java.io.IOException;

public class LocalEmailService implements EmailService {
    @Override
    public EmailVO create(String toEMail) throws IOException {
        return null;
    }

    @Override
    public Boolean verify(String verCode) {
        return null;
    }
}
