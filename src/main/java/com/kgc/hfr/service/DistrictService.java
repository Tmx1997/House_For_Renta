package com.kgc.hfr.service;

import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.District;
import com.kgc.hfr.entity.DistrictExample;
import com.kgc.hfr.entity.Street;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DistrictService {
    long countByExample(DistrictExample example);

    int deleteByExample(DistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    PageInfo selectByExample(DistrictExample example, Integer page, Integer rows);
    List<District> selectByExample();

    District selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByExample(@Param("record") District record, @Param("example") DistrictExample example);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

	PageInfo<Street> selectStreetById(Integer startId, Integer page, Integer rows);

	List<Street> selectStreetById(Integer dId);
}