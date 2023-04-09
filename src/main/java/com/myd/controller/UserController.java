package com.myd.controller;

import com.myd.service.InfoService;
import com.myd.models.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author myd
 * @date 2023/4/5  10:19
 */

@RestController
//@RequestMapping("/talk")
@Slf4j
public class UserController {



//    @Autowired
//    UserMapper userMapper;
//    @Autowired
//    UserService userService;
//    @Autowired
//    DepMapper depMapper;

    @Autowired
    InfoService infoService;

    @PostMapping ("/info")
    public Info getInfo(@RequestBody Info info) throws Exception {

        log.info(info.toString());
////        userMapper.insert(info.getUsers())
//        depMapper.insert(info.getDep());
//        userService.saveBatch(info.getUsers());

        log.info(infoService.toString());

        infoService.saveInfo(info);

        return info;
    }
}
