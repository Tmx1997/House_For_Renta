package com.kgc.hfr.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.Street;
import com.kgc.hfr.entity.StreetExample;
import com.kgc.hfr.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Street")
public class StreetController {
	@Autowired
	StreetService service;
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Object> getAll(Integer page, Integer rows){
		PageInfo pageInfo = service.selectByExample(new StreetExample(), page, rows);
		Map<String,Object>map=new HashMap<>();
		map.put("rows", pageInfo.getList());
		map.put("total", pageInfo.getTotal());
		return map;
	}
	@RequestMapping("/deleteBySomething")
	@ResponseBody
	public String deleteBySomething(@RequestParam(value = "ids") Integer[]ids){
		System.out.println("ids = " + ids);
		int delete=service.deleteBySomething(ids);
		System.out.println("delete = " + delete);
		return "{\"result\":"+delete+"}";
	}
	@RequestMapping(value = "/insert")
	@ResponseBody
	public String insert(Street street){
		System.out.println("street = " + street);
		int i = service.insertSelective(street);
		System.out.println("添加 = " + i);
		return "{\"result\":"+i+"}";
	}
	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(Street street){
		System.out.println("street = " + street);
		int update = service.updateByPrimaryKeySelective(street);
		System.out.println("update = " + update);
		return "{\"result\":"+update+"}";
	}
}
