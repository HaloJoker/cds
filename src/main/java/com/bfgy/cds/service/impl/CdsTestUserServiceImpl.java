package com.bfgy.cds.service.impl;

import com.bfgy.cds.dao.TestUserMapper;
import com.bfgy.cds.entity.TestUser;
import com.bfgy.cds.service.CdsTestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liuzhiqiang
 * @Date 2019/7/15
 */
@Service
public class CdsTestUserServiceImpl implements CdsTestUserService {

    @Autowired
    private TestUserMapper userMapper;

    @Override
    public void add(TestUser user) {
        userMapper.insert(user);
    }
}
