package com.kgc.hfr.controller;

import com.kgc.hfr.entity.Users;
import com.kgc.hfr.service.UsersService;
import com.kgc.hfr.util.CookieUtil;
import com.kgc.hfr.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/Register/")
public class RegisterController {
	@Autowired
	private UsersService service;
	//注册查询
	@RequestMapping(value = "registerUsers")
	@ResponseBody
	public String registerUsers(String name){
		int register= service.selectByExample(name);
		System.out.println("register = " + register);
		return "{\"result\":"+register+"}";//返回json
	}
	@RequestMapping("insertUsers")
	public String insertUsers(Users users){
		System.out.println("users = " + users);
		users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
		int insert = service.insertSelective(users);
		return "login";//返回json
	}

	@RequestMapping("loginUsers")
	public String loginUsers(Users users, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("users = " + users);
		ArrayList list=new ArrayList();
		list.isEmpty();
		users.setPassword(users.getPassword());
		Users u = service.selectByExample(users);
		System.out.println("login = " + u);
		if(u!=null) {
			//中文编码设置
			String data=java.net.URLEncoder.encode(u.getName(), "utf-8");
			Cookie []cookie={
					new Cookie("username",data),
					new Cookie("userId",String.valueOf(u.getId()))
			};
			for (Cookie c : cookie) {
				c.setMaxAge(60*60*24);
				c.setPath("/");
				response.addCookie(c);
			}
			System.out.println("guanli");
			return "redirect:/HouseRent/returnHouseManage";
		}
		 return "login";
	}
	@RequestMapping(value = "returnPublish")
	public String returnPublish(){
		return "publish";
	}
	//退出登录
	@RequestMapping(value = "logoutHouse")
	public String logoutHouse(HttpServletRequest request, HttpServletResponse response){
		System.out.println("退出登录");
		System.out.println("cookie"+request.getCookies()[0].getValue());
		CookieUtil.delCookie(request,response ,"username" );
		CookieUtil.delCookie(request,response ,"userId" );
		return "login";
	}
}
