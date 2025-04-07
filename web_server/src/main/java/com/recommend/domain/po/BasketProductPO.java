package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 购物篮商品关联实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("basket_product")
public class BasketProductPO {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 购物篮ID */
    private Long basketId;

    /** 商品ID */
    private Long productId;

    /** 数量 */
    private Integer quantity;

    /** 创建时间（毫秒级时间戳） */
    private Long createTime;

    /** 更新时间（毫秒级时间戳） */
    private Long updateTime;
}

