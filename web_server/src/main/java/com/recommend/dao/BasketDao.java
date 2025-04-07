package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.BasketPO;
import com.recommend.mapper.BasketMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BasketDao extends ServiceImpl<BasketMapper, BasketPO> implements IService<BasketPO> {
}
