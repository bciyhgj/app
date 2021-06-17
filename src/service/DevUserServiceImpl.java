package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.DevUserMapper;

import pojo.AppCategory;
import pojo.AppInfo;
import pojo.DataDictionary;
import pojo.DevUser;

@Service("devUserService")
public class DevUserServiceImpl implements DevUserService{

	//登录
	@Resource
	private DevUserMapper devUserMapper;
	@Override
	public DevUser login(String devCode, String devPassword) {
		DevUser devUser=null;
		devUser=devUserMapper.getlogin(devCode);
		if(null!=devUser){
			if(!devUser.getDevPassword().equals(devPassword)){
				devUser=null;
			}
		}
		return devUser;
	}
	//APP状态下拉框
	@Override
	public List<DataDictionary> appStutes(String typeCode) {
		List<DataDictionary> ddt= devUserMapper.getStutes(typeCode);
		return ddt;
	}
	//所属平台下拉框
	@Override
	public List<DataDictionary> appFlatform(String typeCode) {
		List<DataDictionary> dd= devUserMapper.getFlatform(typeCode);
		return dd;
	}
	//一级分类下拉框
	@Override
	public List<AppCategory> appAll(String categoryCode) {
		List<AppCategory> list=devUserMapper.getAll(categoryCode);
		return list;
	}
	//二级分类下拉框
	@Override
	public List<AppCategory> appSecond(int id) {
		List<AppCategory> list1=devUserMapper.getSecond(id);
		return list1;
	}
	@Override
	public List<AppCategory> appSan(int id) {
		List<AppCategory> list=devUserMapper.getSan(id);
		return list;
	}
	@Override
	public List<AppInfo> addCha(int currpageNo,int pageSize,String softwareName, String status,
			String flatformId, String categoryLevel1, String categoryLevel2,
			String categoryLevel3) {
		currpageNo=(currpageNo-1)*pageSize;
		List<AppInfo> list=devUserMapper.add(currpageNo,pageSize,softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
		return list;
	}
	@Override
	public int cont(String softwareName, String status, String flatformId,
			String categoryLevel1, String categoryLevel2, String categoryLevel3) {
		
		return devUserMapper.cont(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
	}
	
	
	

}
