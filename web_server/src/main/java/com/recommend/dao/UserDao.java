package com.recommend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserPO> {
}
