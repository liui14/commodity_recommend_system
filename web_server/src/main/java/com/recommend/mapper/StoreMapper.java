package com.recommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.StorePO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper extends BaseMapper<StorePO> {
}
