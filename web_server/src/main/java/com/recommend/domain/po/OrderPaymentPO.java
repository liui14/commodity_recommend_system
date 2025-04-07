package com.recommend.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_payment")
public class OrderPaymentPO {

    /** 支付记录ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 订单ID */
    private Long orderId;

    /** 支付流水号 */
    private String payNo;

    /** 支付方式: 1-微信, 2-支付宝, 3-银行卡 */
    private Integer payMethod;

    /** 支付金额 */
    private BigDecimal payAmount;

    /** 支付状态: 0-未支付, 1-已支付, 2-失败 */
    private Integer status;

    /** 支付时间 */
    private LocalDateTime payTime;
}

