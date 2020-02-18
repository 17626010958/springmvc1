package cn.appsys.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.dao.dev_userMapper;
import cn.appsys.pojo.dev_user;

@Controller
@RequestMapping("/devuser")
public class devUserLogin {
        
	@Autowired
	dev_userMapper mapper;
	
	@RequestMapping("/login")
	public String login(dev_user dev_user,HttpSession session,HttpServletRequest request){
		if(mapper.findUser(dev_user)==null){
	    	 request.setAttribute("error", "用户名或密码错误");
			return "/jsp/devlogin";
		}
		session.setAttribute("devUserSession",mapper.findUser(dev_user));
		return "jsp/developer/main";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
	     session.removeAttribute("devUserSession");
		return "index";
	}
}
