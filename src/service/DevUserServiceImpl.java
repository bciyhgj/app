package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.DevUserMapper;

import pojo.DevUser;

@Service("devUserService")
public class DevUserServiceImpl implements DevUserService{

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

}
