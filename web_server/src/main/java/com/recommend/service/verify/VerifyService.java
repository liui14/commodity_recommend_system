package com.recommend.service.verify;

import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * @Description: 验证码的存储及校验
 * @Author XMuser
 * @Date 2021-06-03 14:05
 */
@Service
public interface VerifyService {

    /**
     * 将创建好的验证码存储，并设置时效
     *
     * @return {@link String}
     * @throws IOException ioexception
     */
    String create() throws IOException;

    /**
     * 检验输入的验证码是否正确
     *
     * @param verCode 验证码
     * @return boolean
     */
    Boolean verify(String verCode);
}
