package com.kgc.hfr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.Street;
import com.kgc.hfr.entity.StreetExample;
import com.kgc.hfr.mapper.StreetMapper;
import com.kgc.hfr.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StreetServiceImpl implements StreetService {
	@Autowired
	StreetMapper mapper;
	@Override
	public long countByExample(StreetExample example) {
		return 0;
	}

	@Override
	public int deleteByExample(StreetExample example) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(Street record) {
		return 0;
	}

	@Override
	public int insertSelective(Street record) {
		return mapper.insertSelective(record);
	}

	@Override
	public PageInfo selectByExample(StreetExample example,Integer page,Integer row) {
		PageHelper.startPage(page,row );
		PageInfo pageInfo=new PageInfo(mapper.selectByExample(example));
		return pageInfo;
	}

	@Override
	public List<Street> selectByExample() {
		return mapper.selectByExample(new StreetExample());
	}

	@Override
	public Street selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByExampleSelective(Street record, StreetExample example) {
		return 0;
	}

	@Override
	public int updateByExample(Street record, StreetExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Street record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Street record) {
		return 0;
	}

	@Override
	public int deleteBySomething(Integer[] ids) {
		return mapper.deleteBySomething(ids);
	}
}
