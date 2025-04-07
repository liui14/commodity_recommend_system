package com.recommend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.ProductReviewPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductReviewMapper extends BaseMapper<ProductReviewPO> {
}
