package com.myd;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.myd.dao.UserMapper;
import com.myd.models.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @author myd
 * @date 2023/4/5  20:24
 */

//@springB
@SpringBootTest
public class TestAPI {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("column","value");//where条件
        userMapper.update(new User(),wrapper);
        System.out.println("userMapper:"+userMapper);
        userMapper.deleteByMap(new HashMap<>());
    }
}
