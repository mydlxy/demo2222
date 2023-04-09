package com.myd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myd.dao.UserMapper;
import com.myd.service.UserService;
import com.myd.models.User;
import org.springframework.stereotype.Service;

/**
 * @author myd
 * @date 2023/4/5  22:13
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
