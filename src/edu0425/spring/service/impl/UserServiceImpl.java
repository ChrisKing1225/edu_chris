package edu0425.spring.service.impl;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.alibaba.fastjson.JSONArray;

import edu0425.common.util.MD5Util;
import edu0425.spring.dao.mapper.UserMapper;
import edu0425.spring.service.UserService;
import edu0425.spring.vo.LoginInfo;
import edu0425.spring.vo.UserInfo;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserInfo getUserByloginId(String loginId) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginId(loginId);
	}

	@Override
	public boolean loginValid(LoginInfo login, HttpSession session) {

		if(StringUtils.isBlank(login.getLoginId()))
			return false;
		
		UserInfo user=getUserByloginId(login.getLoginId());
		if(user!=null) {
			if(user.getPassword().equals(MD5Util.textToMD5U16(login.getPassword()))) {
				login.setUsername(user.getUserName());
				session.setAttribute("USER_SESSION",login);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public JSONArray getPermissions( String loginId) {
		Set<String> permissions=userMapper.getPermissions(loginId);
		JSONArray jsonArray = new JSONArray();
		for(String s: permissions) {
			jsonArray.add(s);
		}
		return jsonArray;
	}
}
