package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import pojo.AppCategory;
import pojo.AppInfo;
import pojo.DataDictionary;
import pojo.DevUser;
import pojo.Page;

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
	/**
	 * @note登录
	 * 
	 * */
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
	/**
	 * @note 下拉框
	 * 
	 * */
	@RequestMapping(value ="/list")
	public String appinfolist(String categoryCode, String typeCode, Model mm,
			@RequestParam(value="currpageNo",required=false)String currpageNo,
			@RequestParam(value="softwareName",required=false)String softwareName,
			@RequestParam(value="queryStatus",required=false)String status,
			@RequestParam(value="queryFlatformId",required=false)String flatformId,
			@RequestParam(value="queryCategoryLevel1",required=false)String categoryLevel1,
			@RequestParam(value="queryCategoryLevel2",required=false)String categoryLevel2,
			@RequestParam(value="queryCategoryLevel3",required=false)String categoryLevel3){
		//APP状态下拉框
		List<DataDictionary> list=devUserService.appStutes(typeCode);
		mm.addAttribute("statusList",list);
		//所属平台下拉框
		List<DataDictionary> list1=devUserService.appFlatform(typeCode);
		mm.addAttribute("flatFormList", list1);
		//一级分类下拉框
		List<AppCategory> list2=devUserService.appAll(categoryCode);
		mm.addAttribute("categoryLevel1List", list2);
		
		int pageSize=5;
		
		if(currpageNo==null){
			currpageNo="1";
		}
		int deng=Integer.parseInt(currpageNo);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setCurrpageNo(deng);
		page.setTotalCount(devUserService.cont(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3));
		List<AppInfo> list45 =devUserService.addCha(deng,pageSize,softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
		mm.addAttribute("appInfoList", list45);
		mm.addAttribute("pages", page);
		return "appinfolist";
	}
	/**
	 * @note 二级分类下拉框
	 * */
	@RequestMapping(value ="categorylevellist.json",produces=("application/json;charset=utf-8"))
	@ResponseBody
	public String appinfo(@RequestParam int pid){
		List<AppCategory> list=devUserService.appSecond(pid);
		return JSONArray.toJSONString(list);
	}
	/**
	 * @note 三级分类下拉框
	 * */
	@RequestMapping(value ="categorylevellist1.json",produces=("application/json;charset=utf-8"))
	@ResponseBody
	public String appinfoSan(@RequestParam int pid){
		List<AppCategory> list=devUserService.appSan(pid);
		return JSONArray.toJSONString(list);
	}
	/*@RequestMapping(value ="/dolist")
	public String add(
			Model m,
			@RequestParam(value="softwareName",required=false)String softwareName,
			@RequestParam(value="queryStatus",required=false)String status,
			@RequestParam(value="queryFlatformId",required=false)String flatformId,
			@RequestParam(value="queryCategoryLevel1",required=false)String categoryLevel1,
			@RequestParam(value="queryCategoryLevel2",required=false)String categoryLevel2,
			@RequestParam(value="queryCategoryLevel3",required=false)String categoryLevel3){
		List<AppInfo> list =devUserService.addCha(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
		m.addAttribute("appInfoList", list);
		//return "list";
		
		return "list";
		
	}*/
	/**
	 * @note 新增
	 * 
	 * */
	@RequestMapping("/appinfoadd")
	public String appInfoAdd(AppInfo app,Model m){
		m.addAttribute(app);
		return "appinfoadd";
		
	}
}
