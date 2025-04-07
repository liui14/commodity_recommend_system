package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order")
public class OrderPO {

    /** 订单ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 订单编号 */
    private String orderNo;

    /** 订单总金额 */
    private BigDecimal totalPrice;

    /** 订单状态: 0-待支付, 1-已支付, 2-待发货, 3-已发货, 4-完成, -1-取消 */
    private Integer status;

    /** 下单时间 */
    private LocalDateTime createTime;

    /** 更新时间 */
    private LocalDateTime updateTime;
}

