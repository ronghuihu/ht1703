package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.Module;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public interface ModuleMapper {
    public List<Module> findAll();

    void deleteModules(String[] moduleIds);

    void saveModule(Module module);

    Module findOne(String moduleId);

    void updateState(@Param("moduleIds")String[] moduleIds, @Param("state")int state);

    @Select("select module_id from role_module_p where role_id = #{roleId}")
    List<String> findRoleModuleListByRoleId(String roleId);


}
