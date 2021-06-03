package service;

import java.util.List;

import pojo.AppCategory;
import pojo.DataDictionary;
import pojo.DevUser;



public interface DevUserService {

	//登录
    public DevUser login(String devCode,String devPassword);
    
    //APP状态下拉框
    List<DataDictionary> appStutes(String typeCode);
    
    //所属平台下拉框
    List<DataDictionary> appFlatform(String typeCode);
    
    //一级分类下拉框
  	List<AppCategory> appAll(String categoryCode);
  	
  	//二级分类下拉框
  	List<AppCategory> appSecond(int id);
  	
  	//三级分类下拉框
  	List<AppCategory> appSan(int id);
}
