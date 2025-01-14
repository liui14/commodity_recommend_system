package com.recommend.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recommend.dao.UserDao;
import com.recommend.domain.po.UserPO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserPO> implements UserService {
}
