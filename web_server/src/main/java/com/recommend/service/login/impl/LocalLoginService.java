package com.recommend.service.login.impl;

import com.recommend.domain.bo.LoginUser;
import com.recommend.service.login.LoginService;

import java.util.Map;

public class LocalLoginService implements LoginService {

    @Override
    public String success(Map<String, String> param) {
        return "";
    }

    @Override
    public LoginUser get() {
        return null;
    }
}
