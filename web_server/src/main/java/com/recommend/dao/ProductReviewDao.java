package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.ProductReviewPO;
import com.recommend.mapper.ProductReviewMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductReviewDao extends ServiceImpl<ProductReviewMapper, ProductReviewPO> implements IService<ProductReviewPO> {
}
