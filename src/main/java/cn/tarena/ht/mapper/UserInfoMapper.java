package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
	
//	public void saveUserInfo(UserInfo userInfo);
//
//	public void deleteUserInfo(String[] userIds);

	public List<UserInfo> findAll();

    void saveUserInfo(UserInfo userInfo);
}
