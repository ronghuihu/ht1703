package cn.tarena.ht.service;

import cn.tarena.ht.pojo.Role;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface RoleService {
    public List<Role> findAll();

    void deleteRoles(String[] roleIds);

    void save(Role role);

    Role findOne(String roleId);

    void update(Role role);

    void saveRoleModule(String[] moduleIds, String roleId);
}
