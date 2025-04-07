package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.OrderPO;
import com.recommend.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao extends ServiceImpl<OrderMapper, OrderPO> implements IService<OrderPO> {
}
