package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.CartPO;
import com.recommend.mapper.CartMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao extends ServiceImpl<CartMapper, CartPO> implements IService<CartPO> {
}
