package cn.tarena.ht.service.ServiceImpl;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/5/27.
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Resource
    private ModuleMapper moduleMapper;
    public List<Module> findAll() {
        return moduleMapper.findAll();
    }

    public void deleteModules(String[] moduleIds) {
        moduleMapper.deleteModules(moduleIds);
    }

    public void saveModule(Module module) {
        module.setModuleId(UUID.randomUUID().toString());
        module.setState(1);
        moduleMapper.saveModule(module);
    }

    public void updateModule(String moduleId) {

    }

    public Module findOne(String moduleId) {
        return moduleMapper.findOne(moduleId);
    }

    public void toUpdateState(String[] moduleIds, int state) {
        moduleMapper.updateState(moduleIds, state);
    }

    public List<String> findRoleModuleListByRoleId(String roleId) {
        return moduleMapper.findRoleModuleListByRoleId(roleId);
    }
}
