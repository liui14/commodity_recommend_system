package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.BasketProductPO;
import com.recommend.mapper.BasketProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BasketProductDao extends ServiceImpl<BasketProductMapper, BasketProductPO> implements IService<BasketProductPO> {
}
