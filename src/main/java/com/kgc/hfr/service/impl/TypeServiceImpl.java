package com.kgc.hfr.service.impl;

import com.kgc.hfr.entity.Type;
import com.kgc.hfr.entity.TypeExample;
import com.kgc.hfr.mapper.TypeMapper;
import com.kgc.hfr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeMapper mapper;
	@Override
	public long countByExample(TypeExample example) {
		return 0;
	}

	@Override
	public int deleteByExample(TypeExample example) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(Type record) {
		return 0;
	}

	@Override
	public int insertSelective(Type record) {
		return 0;
	}

	@Override
	public List<Type> selectByExample() {
		TypeExample example=new TypeExample();
		return mapper.selectByExample(example);
	}

	@Override
	public Type selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByExampleSelective(Type record, TypeExample example) {
		return 0;
	}

	@Override
	public int updateByExample(Type record, TypeExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Type record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Type record) {
		return 0;
	}
}
