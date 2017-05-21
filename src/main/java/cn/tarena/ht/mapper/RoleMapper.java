package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface RoleMapper {

    @Select("SELECT * FROM role_p ORDER BY order_no")
    public List<Role> findAll();


//    @Delete("delete from role_p where role_id in ")
    void deleteRoles(String[] roleIds);

    void save(Role role);

    @Select("SELECT * FROM role_p where role_id = #{roleId}")
    Role findOne(String roleId);

    void update(Role role);

    @Insert("insert into role_module_p(role_id, module_id) values (#{roleId}, #{moduleId})")
    void saveRoleModule(@Param("moduleId") String moduleId,@Param("roleId") String roleId);

    @Delete("delete from role_module_p where role_id = #{roleId}")
    void deleteRoleModuleByRoleId(String roleId);

    void deleteRoleModuleByRoleIds(String[] roleIds);
}
