package com.recommend.service.login;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recommend.domain.bo.LoginUser;
import com.recommend.domain.po.UserPO;

import java.util.Map;

/**
 * @Description: 登录成功后token数据的存储和读取
 * @Author XMuser
 * @Date 2021-06-05 15:27
 */
public interface LoginService {

    /**
     * 登录成功后，存储用户信息，并设置有效期
     *
     * @param param 参数
     * @return {@link String}
     */
    String success(Map<String, String> param);

    /**
     * 获取用户信息
     *
     * @return {@link LoginUser}
     */
    LoginUser get();
}
