package com.kgc.hfr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.House;
import com.kgc.hfr.entity.HouseExample;
import com.kgc.hfr.entity.HouseExt;
import com.kgc.hfr.mapper.HouseMapper;
import com.kgc.hfr.service.HouseService;
import com.kgc.hfr.util.FileUploadUtil;
import com.kgc.hfr.util.StringIDUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseMapper mapper;
	@Override
	public long countByExample(HouseExample example) {
		return 0;
	}

	@Override
	public int deleteByExample(HouseExample example) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@Override
	public int insert(House record) {
		return 0;
	}

	@Override
	public int insertSelective(House record, String targetPath,CommonsMultipartFile picture) {
		System.out.println("Service");
		System.out.println("record = " + record);
		Map<String, Object> map = FileUploadUtil.fileUpLoad(targetPath, picture);
		String path = (String) map.get("savePath");
		File file=(File) map.get("file");
		String id = StringIDUtil.getId();
		record.setId(id);
		record.setPath(path);
		record.setIsdel(0);
		record.setIspass(0);
		int insert=0;
		try {
			insert= mapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(insert<1){
				file.delete();
			}
		}
		return insert;
	}

	@Override
	public List<House> selectByExample() {
		HouseExample example=new HouseExample();
		return mapper.selectByExample(example);
	}
	public PageInfo<House> selectByExample(Integer page, Integer rows, Integer userId) {
		HouseExample example=new HouseExample();
		HouseExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		PageHelper.startPage(page, rows);
		List<House> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public PageInfo<HouseExt> selectByUserId(Integer page, Integer rows, Integer userId) {
		PageHelper.startPage(page, rows);
		List<HouseExt> list = mapper.selectByUserId(userId);
		return new PageInfo<>(list);
	}

	@Override
	public HouseExt selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(House record, HouseExample example) {
		return 0;
	}

	@Override
	public int updateByExample(House record, HouseExample example) {
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(House record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(House record) {
		return 0;
	}
}
