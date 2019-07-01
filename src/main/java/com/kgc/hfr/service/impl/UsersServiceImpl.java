package com.kgc.hfr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.Users;
import com.kgc.hfr.entity.UsersConditions;
import com.kgc.hfr.entity.UsersExample;
import com.kgc.hfr.mapper.UsersMapper;
import com.kgc.hfr.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersMapper mapper;
	@Override
	public long countByExample(UsersExample example) {
		return 0;
	}

	@Override
	public int deleteByExample(UsersExample example) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Users record) {
		return 0;
	}

	@Override
	public int insertSelective(Users record) {
		return mapper.insertSelective(record);
	}

	@Override
	public PageInfo selectByExample(UsersConditions message) {
		UsersExample example=new UsersExample();
		UsersExample.Criteria criteria = example.createCriteria();
		if(message.getStartId()!=null)criteria.andIdGreaterThanOrEqualTo(message.getStartId());
		if(message.getEndId()!=null)criteria.andIdLessThanOrEqualTo(message.getEndId());
		if(message.getName()!=null&&message.getName()!="")criteria.andNameEqualTo(message.getName());
		if(message.getTelephone()!=null&&message.getTelephone()!="")criteria.andTelephoneLike("%"+message.getTelephone()+"%");
		PageHelper.startPage(message.getPage(),message.getRows() );
		List<Users> list = mapper.selectByExample(example);
		PageInfo pageInfo=new PageInfo(list);
		return pageInfo;
	}

	@Override
	public int selectByExample(String username) {
		UsersExample example=new UsersExample();
		UsersExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		criteria.andIsadminEqualTo(0);
		List<Users> users = mapper.selectByExample(example);
		return users.size()==0?0:1;
	}

	@Override
	public Users selectByExample(Users users) {
		UsersExample example=new UsersExample();
		UsersExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(users.getName());
		criteria.andPasswordEqualTo(users.getPassword());
		List<Users> us = mapper.selectByExample(example);
		return us.size()==0?null:us.get(0);
	}

	public List<Users>selectAll(){
		List<Users> list = mapper.selectByExample(new UsersExample());
		return list;
	}

	@Override
	public int deleteByArray(Integer[] xhs) {
		return mapper.deleteByArray(xhs);
	}

	@Override
	public Users selectByPrimaryKey(Integer id) {
		return null;
	}

	@Override
	public int updateByExampleSelective(Users record, UsersExample example) {
		return 0;
	}

	@Override
	public int updateByExample(Users record, UsersExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		return 0;
	}
}
