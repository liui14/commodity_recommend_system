package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.OrderStorePO;
import com.recommend.mapper.OrderStoreMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderStoreDao extends ServiceImpl<OrderStoreMapper, OrderStorePO> implements IService<OrderStorePO> {
}
