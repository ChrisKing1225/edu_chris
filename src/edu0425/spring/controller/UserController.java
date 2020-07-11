package edu0425.spring.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import edu0425.common.util.MD5Util;
import edu0425.spring.service.UserService;
import edu0425.spring.vo.LoginInfo;
import edu0425.spring.vo.UserInfo;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserInfoByLoginId(@PathVariable String loginId) {
		return userService.getUserByloginId(loginId);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {

		modelMap.put("user", new LoginInfo());
		return "login";

	}

	public String login(LoginInfo user, HttpSession session, ModelMap modelMap) {
		if (userService.loginValid(user, session)) {
			return "redirect:player/index?pageIndex=1&pageSize=10";
		}

		user.setPassword(null);
		modelMap.put("user", user);
		modelMap.put("msg", "賬號或者密碼錯誤");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login2(LoginInfo user, HttpSession session, ModelMap modelMap) {
		// 獲取當前登錄用戶
		Subject subject = SecurityUtils.getSubject();
		// 封裝表單中提交的用戶名和密碼
		UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginId(),
				MD5Util.textToMD5U16(user.getPassword()), user.isRemember());
		try {
			// 调用login方法，传入封装好的token（令牌）
			subject.login(token);
			// 登陆成功跳转
			return "redirect:player/index?pageIndex=1&pageSize=10";
		} catch (Exception e) {
			// 否则返回登陆页，密码置空，显示账号密码错误
			user.setPassword(null);
			modelMap.put("user", user);
			modelMap.put("msg", "账号密码错误");
			return "login";
		}
	}

	@RequestMapping(value = "/permission/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray getPermissions(@PathVariable String loginId) {
		// TODO 根據loginId查詢這個用戶的所有權限關鍵字，以jsona數組的格式返回
		return userService.getPermissions(loginId);
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:login";
	}

	@RequestMapping("/profile/{loginId}")
	public String userProfile(@PathVariable String loginId, ModelMap modelMap) {
		UserInfo user = userService.getUserByloginId(loginId);
		modelMap.put("user", user);
		return "user_profile";
	}
}
