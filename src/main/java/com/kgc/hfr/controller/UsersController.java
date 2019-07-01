package com.kgc.hfr.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.hfr.entity.Users;
import com.kgc.hfr.entity.UsersConditions;
import com.kgc.hfr.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/Users")
public class UsersController {
	@Autowired
	UsersService service;
	@RequestMapping(value = "/getUsers")
	@ResponseBody
	public Map<String,Object> getUsers(UsersConditions message){
		PageInfo pageInfo = service.selectByExample(message);
		Map<String,Object> map=new HashMap();
		map.put("rows",pageInfo.getList() );
		map.put("total", pageInfo.getTotal());
		return map;
	}
	@RequestMapping("/addUsers")
	@ResponseBody
	public String addUsers(Users user){
		int i = service.insertSelective(user);
		System.out.println("添加："+i);
		return "{\"result\":"+i+"}";
	}

	@RequestMapping("/updateUsers")
	@ResponseBody
	public String updateUsers(Users user){
		int i = service.updateByPrimaryKeySelective(user);
		System.out.println("修改："+i);
		return "{\"result\":"+i+"}";
	}
	@RequestMapping("/deleteUsers")
	@ResponseBody
	public String deleteUsers(Integer[]xhs){
		System.out.println("xhs = " + xhs);
		int delete=service.deleteByArray(xhs);
		System.out.println("delete:"+delete);
		return "{\"result\":"+delete+"}";
	}
}
