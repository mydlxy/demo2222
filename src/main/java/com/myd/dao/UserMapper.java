package com.myd.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myd.models.User;
import org.springframework.stereotype.Repository;

/**
 * @author myd
 * @date 2023/4/5  20:17
 */

@Repository
public interface UserMapper extends BaseMapper<User> {
}
