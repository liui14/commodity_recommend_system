package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.StorePO;
import com.recommend.mapper.StoreMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDao extends ServiceImpl<StoreMapper, StorePO> implements IService<StorePO> {
}
