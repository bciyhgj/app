package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.AppCategory;
import pojo.DataDictionary;
import pojo.DevUser;

public interface DevUserMapper {

	//登录
	public DevUser getlogin(@Param("devCode")String devCode);
	
	//APP状态下拉框
	List<DataDictionary> getStutes(@Param("typeCode")String typeCode);
	
	//所属平台下拉框
	List<DataDictionary> getFlatform(@Param("typeCode")String typeCode);
	
	//一级分类下拉框
	List<AppCategory> getAll(@Param("categoryCode")String categoryCode);
	
	//二级分类下拉框
	List<AppCategory> getSecond(@Param("id")int id);
	
	//三级分类下拉框
	List<AppCategory> getSan(@Param("id")int id);
}
