package com.myd.service.impl;

import com.myd.dao.DepMapper;
import com.myd.models.User;
import com.myd.service.InfoService;
import com.myd.service.UserService;
import com.myd.models.Info;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author myd
 * @date 2023/4/5  22:17
 */

@Service
public class InfoServiceImpl  implements InfoService {

    @Autowired
    UserService userService;

    @Autowired
    DepMapper depMapper;


    @Transactional(rollbackFor = {Exception.class,Error.class}
    )
    @Override
    public void saveInfo(Info info) throws Exception {
        try {
            depMapper.insert(info.getDep());
            List<User> users = info.getUsers();
            users.forEach(user -> user.setDepId(info.getDep().getId()));
            userService.saveBatch(info.getUsers());
//            if (true)
//                throw new RuntimeException("exception..");
        }catch(Exception e){
            throw new Exception("exception..");
        }
    }
}
