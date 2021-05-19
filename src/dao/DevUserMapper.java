package dao;

import org.apache.ibatis.annotations.Param;

import pojo.DevUser;

public interface DevUserMapper {

	public DevUser getlogin(@Param("devCode")String devCode);
}
