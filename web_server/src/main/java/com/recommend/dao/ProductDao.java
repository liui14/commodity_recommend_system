package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.ProductPO;
import com.recommend.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends ServiceImpl<ProductMapper, ProductPO> implements IService<ProductPO> {
}
