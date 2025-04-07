package com.recommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.BasketProductPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BasketProductMapper extends BaseMapper<BasketProductPO> {
}
