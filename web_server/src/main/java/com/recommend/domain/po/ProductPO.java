package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;

/**
 * 商品实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product")
public class ProductPO {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 商品名称 */
    private String productName;

    /** 店铺ID */
    private Long storeId;

    /** 原价 */
    private Double oriPrice;

    /** 现价 */
    private Double price;

    /** 简要描述, 卖点等 */
    private String brief;

    /** 商品详情 */
    private String intro;

    /** 商品主图 */
    private String pic;

    /** 商品图片，以,分割 */
    private String imgs;

    /** 商品状态: 1-正常, 0-下架, -1-删除 */
    private Integer status;

    /** 商品分类ID */
    private Long categoryId;

    /** 销量 */
    private Integer soldNum;

    /** 评论数量 */
    private Integer commentNum;

    /** 总库存 */
    private Integer totalStocks;

    /** 录入时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

    /** 上架时间 */
    private Date putawayTime;
}

