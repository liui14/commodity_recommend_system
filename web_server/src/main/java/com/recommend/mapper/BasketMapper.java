package com.recommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.BasketPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BasketMapper extends BaseMapper<BasketPO> {
}
