package com.recommend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.ProductPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDao extends BaseMapper<ProductPO> {
}