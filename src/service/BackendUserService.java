package service;

import pojo.BackendUser;

public interface BackendUserService {

	//登录
	public BackendUser login(String userCode,String userPassword);
}
