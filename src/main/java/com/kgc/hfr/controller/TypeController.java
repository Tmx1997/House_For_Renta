package com.kgc.hfr.controller;

import com.kgc.hfr.entity.Type;
import com.kgc.hfr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Type/")
public class TypeController {
	@Autowired
	TypeService service;
	@RequestMapping(value = "getAll")
	@ResponseBody
	public Map<String, Object> getAll(){
		List<Type>list = service.selectByExample();
		Map<String,Object>map=new HashMap<>();
		map.put("rows",list );
		return map;
	}
}
