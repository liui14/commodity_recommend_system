package com.recommend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recommend.domain.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao extends BaseMapper<UserPO> {
}
