package com.kgc.hfr.service;

import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.Users;
import com.kgc.hfr.entity.UsersExample;
import com.kgc.hfr.entity.UsersConditions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersService {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    PageInfo selectByExample(UsersConditions message);
    int selectByExample(String username);
    Users selectByExample(Users users);

    Users selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectAll();

	int deleteByArray(Integer[] xhs);
}