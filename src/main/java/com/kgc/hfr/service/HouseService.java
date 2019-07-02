package com.kgc.hfr.service;

import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.House;
import com.kgc.hfr.entity.HouseExample;
import com.kgc.hfr.entity.HouseExt;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface HouseService {
    long countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record, String targetPath, CommonsMultipartFile picture);

    List<House> selectByExample();
    PageInfo<House> selectByExample(Integer page, Integer rows, Integer userId);
    PageInfo<HouseExt> selectByUserId(Integer page, Integer rows, Integer userId);

    HouseExt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(String targetPath,House record,CommonsMultipartFile picture);

    int updateByPrimaryKey(House record);
}