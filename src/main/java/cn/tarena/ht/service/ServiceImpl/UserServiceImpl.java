package cn.tarena.ht.service.ServiceImpl;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/5/25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public void saveUserRole(String[] roleIds, String userId) {

          userMapper.deleteByUserId(userId);
        for (String roleId: roleIds){
          userMapper.saveUserRole(roleId, userId);
        }
    }

    public List<Role> findRoleByUserId(String userId) {
        return userMapper.findRoleByUserId(userId);
    }

    public void saveUser(User user) {
        String id =UUID.randomUUID().toString();
        user.setUserId(id);
        Date date = new Date();
        user.setCreateTime(date);
        userMapper.saveUser(user);

        UserInfo userInfo = user.getUserInfo();
        userInfo.setUserInfoId(id);
        userInfo.setCreateTime(date);
        userInfo.setJoinDate(date);
        userInfoMapper.saveUserInfo(userInfo);
    }

    public User findUserByNameAndPassword(String userName, String password) {
        return  userMapper.findUserByNameAndPassword(userName, password);
    }

    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

}
