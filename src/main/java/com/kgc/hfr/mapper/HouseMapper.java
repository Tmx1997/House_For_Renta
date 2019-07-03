package com.kgc.hfr.mapper;

import com.kgc.hfr.entity.House;
import com.kgc.hfr.entity.HouseExample;
import java.util.List;

import com.kgc.hfr.entity.HouseExt;
import com.kgc.hfr.entity.HouseExtExample;
import org.apache.ibatis.annotations.Param;

public interface HouseMapper {
    long countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);
    List<HouseExt> selectByConditions(HouseExtExample example);
    List<HouseExt> selectByUserId(Integer userId);

    HouseExt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
}