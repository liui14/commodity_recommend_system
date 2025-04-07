package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 店铺购物篮实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("basket")
public class BasketPO {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 购物车ID */
    private Long cartId;

    /** 店铺ID */
    private Long storeId;

    /** 创建时间（毫秒级时间戳） */
    private Long createTime;

    /** 更新时间（毫秒级时间戳） */
    private Long updateTime;
}
