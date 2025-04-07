package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;

/**
 * 店铺实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("li_store")
public class StorePO {

    /** 主键ID */
    @TableId(type = IdType.INPUT)
    private Long id;

    /** 用户ID */
    private String userId;

    /** 用户名称 */
    private String userName;

    /** 是否自营 */
    private Boolean selfOperated;

    /** 店铺状态 */
    private String storeDisable;

    /** 店铺关闭时间 */
    private Date storeEndTime;

    /** 店铺logo */
    private String storeLogo;

    /** 店铺名称 */
    private String storeName;

    /** 店铺简介 */
    private String storeDesc;

    /** 物流评分 */
    private Double deliveryScore;

    /** 描述评分 */
    private Double descriptionScore;

    /** 服务评分 */
    private Double serviceScore;

    /** 商品数量 */
    private Integer goodsNum;

    /** 收藏数量 */
    private Integer collectionNum;

    /** 商户签名 */
    private String yzfMpSign;

    /** 签名 */
    private String yzfSign;

    /** 商户euid */
    private String merchantEuid;

    /** 默认页面是否开启 */
    private Boolean pageShow;

    /** 是否开启自提 */
    private Boolean selfPickFlag;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 删除标志 */
    private Boolean deleteFlag;
}

