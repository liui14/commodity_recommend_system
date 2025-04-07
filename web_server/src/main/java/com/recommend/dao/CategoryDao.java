package com.recommend.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.domain.po.CategoryPO;
import com.recommend.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends ServiceImpl<CategoryMapper, CategoryPO> implements IService<CategoryPO> {
}
