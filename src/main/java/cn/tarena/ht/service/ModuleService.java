package cn.tarena.ht.service;

import cn.tarena.ht.pojo.Module;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public interface ModuleService {

    public List<Module> findAll();

    void deleteModules(String... moduleIds);

    void saveModule(Module module);


    Module findOne(String moduleId);

    void toUpdateState(String[] moduleIds, int state);

    List<String> findRoleModuleListByRoleId(String roleId);
}
