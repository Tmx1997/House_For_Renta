package com.kgc.hfr.service;

import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.Street;
import com.kgc.hfr.entity.StreetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StreetService {
    long countByExample(StreetExample example);

    int deleteByExample(StreetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    PageInfo selectByExample(StreetExample example, Integer page, Integer row);
    List<Street> selectByExample();

    Street selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Street record, @Param("example") StreetExample example);

    int updateByExample(@Param("record") Street record, @Param("example") StreetExample example);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    int deleteBySomething(Integer[] ids);
}