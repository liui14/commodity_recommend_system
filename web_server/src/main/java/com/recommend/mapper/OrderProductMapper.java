package com.recommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.OrderProductPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderProductMapper extends BaseMapper<OrderProductPO> {
}
