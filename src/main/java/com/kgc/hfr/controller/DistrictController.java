package com.kgc.hfr.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.*;
import com.kgc.hfr.service.DistrictService;
import com.kgc.hfr.service.StreetService;
import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/District")
public class DistrictController {
	@Autowired
	DistrictService service;

	/**
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Object> getAll(Integer page, Integer rows){
		PageInfo pageInfo = service.selectByExample(new DistrictExample(), page, rows);
		Map<String,Object> map=new HashMap<>();
		map.put("rows",pageInfo.getList() );
		map.put("total", pageInfo.getTotal());
		return map;
	}
	@RequestMapping("/getDistrict")
	@ResponseBody
	public Map<String, Object> getAll(){
		List<District> list= service.selectByExample();
		Map<String,Object> map=new HashMap<>();
		map.put("rows",list);
		return map;
	}
	@RequestMapping("/addOne")
	@ResponseBody
	public String addUsers(District district){
		int i = service.insertSelective(district);
		System.out.println("添加："+i);
		return "{\"result\":"+i+"}";
	}

	@RequestMapping("/updateOne")
	@ResponseBody
	public String updateUsers(District district){
		int i = service.updateByPrimaryKeySelective(district);
		System.out.println("修改："+i);
		return "{\"result\":"+i+"}";
	}
	@RequestMapping("/deleteBySomething")
	@ResponseBody
	public String deleteUsers(Integer[]xhs){
		System.out.println("xhs = " + xhs);
		int delete=0;
		for (Integer i : xhs) {
			delete+=service.deleteByPrimaryKey(i);
		}
		System.out.println("delete:"+delete);
		return "{\"result\":"+delete+"}";
	}
	@RequestMapping(value = "/selectStreetById")
	@ResponseBody
	public Map<String,Object>selectStreetById(UsersConditions conditions){
		System.out.println(conditions);
		PageInfo<Street> pageInfo=service.selectStreetById(conditions.getStartId(),conditions.getPage(),conditions.getRows());
		Map<String,Object>map=new HashMap<>();
		map.put("rows",pageInfo.getList() );
		map.put("total",pageInfo.getTotal());
		return map;
	}
	@RequestMapping(value = "/getStreets")
	@ResponseBody
	public Map<String,Object>selectStreetById(Integer dId){
		System.out.println("dId = " + dId);
		if(dId==null)return null;
		List<Street>list=service.selectStreetById(dId);
		Map<String,Object>map=new HashMap<>();
		map.put("rows",list);
		return map;
	}

}
