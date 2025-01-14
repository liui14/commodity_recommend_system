package com.recommend.domain.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息类
 *
 * @author XMuser
 * @date 2021/06/17
 */
@Data
public class LoginUser implements Serializable {

    private static final long serialVersionUID = -6460656217902228489L;
    private String uname;
    private String upass;
}
