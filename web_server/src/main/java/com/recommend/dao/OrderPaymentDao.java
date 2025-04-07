package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.OrderPaymentPO;
import com.recommend.mapper.OrderPaymentMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderPaymentDao extends ServiceImpl<OrderPaymentMapper, OrderPaymentPO> implements IService<OrderPaymentPO> {
}
