package service;

import pojo.DevUser;



public interface DevUserService {

	//登录
    public DevUser login(String devCode,String devPassword);
}
