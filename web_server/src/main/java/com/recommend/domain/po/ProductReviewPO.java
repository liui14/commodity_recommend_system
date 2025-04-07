package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product_review")
public class ProductReviewPO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Long orderProductId;

    private Long userId;

    private Long productId;

    private Long storeId;

    private Integer rating; // 评分 1-5

    private String content; // 评价内容

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> imageUrls; // 评价图片 JSON 数组

    private Integer status; // 1-正常 0-删除

    private Boolean isAnonymous; // 是否匿名评价

    private String replyContent; // 商家回复

    private LocalDateTime replyTime; // 商家回复时间

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime updateTime; // 更新时间
}

