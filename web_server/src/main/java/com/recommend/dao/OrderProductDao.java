package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.OrderProductPO;
import com.recommend.mapper.OrderProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductDao extends ServiceImpl<OrderProductMapper, OrderProductPO> implements IService<OrderProductPO> {
}
