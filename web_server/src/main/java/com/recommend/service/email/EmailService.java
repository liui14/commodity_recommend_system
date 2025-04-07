package com.recommend.service.email;

import com.recommend.domain.vo.EmailVO;

import java.io.IOException;

public interface EmailService {
    EmailVO create(String toEMail) throws IOException;

    /**
     * 检验输入的验证码是否正确
     *
     * @param email   邮箱
     * @param verCode 验证码
     * @return boolean
     */
    Boolean verify(String email,String verCode);
}
