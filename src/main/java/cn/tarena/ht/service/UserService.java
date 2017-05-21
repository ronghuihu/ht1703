package cn.tarena.ht.service;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public interface UserService {

    public List<User> findAll();

    void saveUserRole(String[] roleIds, String userId);

    List<Role> findRoleByUserId(String userId);

    void saveUser(User user);

    User findUserByNameAndPassword(String userName, String password);

    User findUserByUserName(String username);
}
