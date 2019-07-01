package com.kgc.hfr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.District;
import com.kgc.hfr.entity.DistrictExample;
import com.kgc.hfr.entity.Street;
import com.kgc.hfr.entity.StreetExample;
import com.kgc.hfr.mapper.DistrictMapper;
import com.kgc.hfr.mapper.StreetMapper;
import com.kgc.hfr.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DistrictServiceIMpl implements DistrictService {
    @Autowired
    DistrictMapper mapper;
    @Autowired
	StreetMapper streetMapper;

    @Override
    public long countByExample(DistrictExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(DistrictExample example) {
        return 0;
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer id) {
	    try {
		    mapper.deleteByPrimaryKey(id);
		    streetMapper.deleteByDid(id);
		    return 1;
	    } catch (Exception e) {
		    e.printStackTrace();
		    return 0;
	    }
    }

    @Override
    public int insert(District record) {
        return 0;
    }

    @Override
    public int insertSelective(District record) {
        return mapper.insertSelective(record);
    }

    @Override
    public PageInfo selectByExample(DistrictExample example,Integer page, Integer rows) {
        PageHelper.startPage(page,rows );
        List<District> list = mapper.selectByExample(example);
	    return new PageInfo<>(list);
    }
    public List<District> selectByExample() {
        List<District> list = mapper.selectByExample(new DistrictExample());
        return list;
    }

    @Override
    public District selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(District record, DistrictExample example) {
        return 0;
    }

    @Override
    public int updateByExample(District record, DistrictExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(District record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(District record) {
        return 0;
    }

	@Override
	public PageInfo<Street> selectStreetById(Integer startId, Integer page, Integer rows) {
		StreetExample example=new StreetExample();
		StreetExample.Criteria criteria = example.createCriteria();
		criteria.andDistrictIdEqualTo(startId);
		PageHelper.startPage(page,rows );
		List<Street> list = streetMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<Street> selectStreetById(Integer dId) {
    	StreetExample example=new StreetExample();
		StreetExample.Criteria criteria = example.createCriteria();
		criteria.andDistrictIdEqualTo(dId);
		return streetMapper.selectByExample(example);
	}
}