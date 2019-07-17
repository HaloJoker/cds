package com.bfgy.cds.dao;

import com.bfgy.cds.entity.TestUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);
}