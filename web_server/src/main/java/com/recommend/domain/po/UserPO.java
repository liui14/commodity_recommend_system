package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

@Data
@TableName(value = "user")
public class UserPO {

    @TableId(type = IdType.AUTO)
    private Long id;  // 主键ID


    private String thirdAccountId;  // 第三方用户ID


    private String userName;  // 用户名


    private String email;  // 用户邮箱


    private String password;  // 密码


    private Integer loginType;  // 登录方式: 0-微信登录，1-账号密码登录

    @TableLogic(value = "0", delval = "1")
    private Integer deleted;  // 是否删除


    private long createTime;  // 创建时间


    private long updateTime;  // 最后更新时间

}

