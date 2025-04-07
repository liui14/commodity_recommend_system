package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单店铺实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_store")
public class OrderStorePO {

    /** 订单店铺ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 订单ID */
    private Long orderId;

    /** 店铺ID */
    private Long storeId;

    /** 店铺订单金额 */
    private BigDecimal storeTotalPrice;

    /** 店铺订单状态: 0-待支付, 1-已支付, 2-待发货, 3-已发货, 4-完成, -1-取消 */
    private Integer status;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新时间 */
    private LocalDateTime updateTime;
}

