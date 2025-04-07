package com.recommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.ProductPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<ProductPO> {
}
