package dao;

import org.apache.ibatis.annotations.Param;

import pojo.BackendUser;

public interface BackendUserMapper {

	//登录
	public BackendUser getlogin(@Param("userCode")String userCode);
}
