package com.kgc.hfr.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.House;
import com.kgc.hfr.entity.HouseExt;
import com.kgc.hfr.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/HouseRent/")
public class HouseRentController {
	@Autowired
	HouseService service;
	@RequestMapping(value = "publishHouse")
	public String insertHouse(House house, @RequestParam(value = "picture",required = false) CommonsMultipartFile picture){
		System.out.println("house = " + house);
		String targetPath="F:\\images\\";
		int insert = service.insertSelective(house, targetPath, picture);
		System.out.println("insert = " + insert);
		return "guanli";
	}
	@RequestMapping(value = "selectHouse")
	@ResponseBody
	public Map<String, Object> selectHouse(@RequestParam(value = "userId",required = false) Integer userId, @RequestParam(value = "page",required = false,defaultValue = "1") Integer page){
		Integer pageSize=3;
		System.out.println("page = " + page);
		System.out.println("userId = " + userId);
		Map<String,Object> map=new HashMap<>();
		PageInfo<HouseExt> pageInfo = service.selectByUserId(page, pageSize, userId);
		map.put("rows",pageInfo.getList() );
		map.put("total", pageInfo.getTotal());
		map.put("page", page);
		map.put("pages", pageInfo.getPages());
		map.put("pageInfo", pageInfo);
		return map;
	}
	@RequestMapping(value = "queryByHouseId")
	@ResponseBody
	public HouseExt queryByHouseId(@RequestParam(value = "id") String id){
		System.out.println("查询单条house");
		System.out.println("id = " + id);
		HouseExt house = service.selectByPrimaryKey(id);
		System.out.println("house = " + house);
		return house;
	}
}
