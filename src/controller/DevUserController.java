package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.DevUser;

import service.DevUserService;
import tools.Constants;

@Controller
public class DevUserController {

	@Resource
	DevUserService devUserService;
	
	@RequestMapping("/login")
	public String index(){
		
		return "login";
	}
	@RequestMapping(value="/doLogin", method = RequestMethod.POST)
	public String list(@RequestParam("devCode")String devCode, String devPassword, Model model,HttpSession session){
		DevUser user=devUserService.login(devCode, devPassword);
		if(user==null){
			model.addAttribute("eeror","登录失败");
		}else{
			session.setAttribute("username", user);
			return "redirect:/main";
			//model.addAttribute("eeror", "登录成功");
		}
		return "login";
	}
	@RequestMapping(value ="/main")
	public String main(HttpSession session){
		if(null==session.getAttribute("username")){
			return "login";
		}
		session.setAttribute(Constants.USER_SESSION, "user");
		return "main";
	}
}
