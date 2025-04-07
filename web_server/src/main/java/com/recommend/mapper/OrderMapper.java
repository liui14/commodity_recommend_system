package com.recommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.OrderPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {
}
