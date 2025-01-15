package com.recommend.service.verify.impl;

import com.recommend.domain.vo.ImageVO;
import com.recommend.interceptor.RequestHolder;
import com.recommend.service.verify.VerifyService;
import com.recommend.util.CaptchaImageUtils;
import com.recommend.util.CommonsUtil;
import com.recommend.util.RedisUtil;

import java.util.Optional;

public class RedisVerifyService implements VerifyService {

    private final RedisUtil redisUtil;

    public RedisVerifyService(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * 将创建好的验证码使用redis存储，使用token，验证码作为存储的键值，时效为2分钟
     *
     * @return {@link String} 返回token和base64形式的验证码图片的json字符串
     */
    @Override
    public ImageVO create() {
        String token = CommonsUtil.getToken();
        CaptchaImageUtils captchaImageUtils = new CaptchaImageUtils();
        String base64 = CaptchaImageUtils.getBase(captchaImageUtils.getImage());
        if (base64 == null) {
            return null;
        }
        redisUtil.set(token, captchaImageUtils.getText(), 2);
        ImageVO imageVO = new ImageVO();
        imageVO.setCodeToken(token);
        imageVO.setImage(base64);
        return imageVO;
    }

    /**
     * 利用请求头中的Code-Token取出在redis中的数据并校验
     *
     * @param verCode 验证码
     * @return boolean 返回验证码校验结果
     */
    @Override
    public Boolean verify(String verCode) {
        Object code = null;
        verCode = verCode.toLowerCase();
        Optional<String> optional = RequestHolder.getCodeToken();
        if (optional.isPresent()) {
            code = redisUtil.get(optional.get());
            code = code == null ? null : code.toString().toLowerCase();
        }
        if(code == null){
            return null;
        }
        return code.equals(verCode);
    }
}
