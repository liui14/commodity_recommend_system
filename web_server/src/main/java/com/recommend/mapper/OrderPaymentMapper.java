package com.recommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.OrderPaymentPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderPaymentMapper extends BaseMapper<OrderPaymentPO> {
}
