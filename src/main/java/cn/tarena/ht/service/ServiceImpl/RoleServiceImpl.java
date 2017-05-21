package cn.tarena.ht.service.ServiceImpl;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/5/26.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    public void deleteRoles(String[] roleIds) {
        roleMapper.deleteRoleModuleByRoleIds(roleIds);
        roleMapper.deleteRoles(roleIds);
    }

    public void save(Role role) {
        role.setRoleId(UUID.randomUUID().toString());
        role.setCreateTime(new Date());
        roleMapper.save(role);
    }

    public Role findOne(String roleId) {
        return roleMapper.findOne(roleId);
    }

    public void update(Role role) {
        roleMapper.update(role);
    }

    public void saveRoleModule(String[] moduleIds, String roleId) {
        roleMapper.deleteRoleModuleByRoleId(roleId);
        for (String moduleId : moduleIds){
            roleMapper.saveRoleModule(moduleId, roleId);
        }
    }
}
