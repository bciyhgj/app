package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.AppCategory;
import pojo.AppInfo;
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
	
	//查询
	List<AppInfo> add(
			@Param("currpageNo")int currpageNo,@Param("pageSize")int pageSize,
			         @Param("softwareName")String softwareName,@Param("status")String status,
			         @Param("flatformId")String flatformId,
			         @Param("categoryLevel1")String categoryLevel1,
			         @Param("categoryLevel2")String categoryLevel2,
			         @Param("categoryLevel3")String categoryLevel3);
	//总页
	int cont(@Param("softwareName")String softwareName,@Param("status")String status,
	         @Param("flatformId")String flatformId,
	         @Param("categoryLevel1")String categoryLevel1,
	         @Param("categoryLevel2")String categoryLevel2,
	         @Param("categoryLevel3")String categoryLevel3);
}
