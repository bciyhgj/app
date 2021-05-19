package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.BackendUserMapper;
import pojo.BackendUser;

@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService{

	@Resource
	private BackendUserMapper backendUserMapper;
	@Override
	public BackendUser login(String userCode, String userPassword) {
		BackendUser user=null;
		user = backendUserMapper.getlogin(userCode);
		if(null!=user){
			if(!user.getUserPassword().equals(userPassword)){
				user=null;
			}
		}
		return user;
	}

}
