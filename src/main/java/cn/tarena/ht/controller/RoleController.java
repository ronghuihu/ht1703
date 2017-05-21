package cn.tarena.ht.controller;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
@Controller
@RequestMapping("/sysadmin/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private ModuleService moduleService;

    @RequestMapping("/list")
    public String findAll(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "/sysadmin/role/jRoleList";
    }


    @RequestMapping("/delete")
    public String toDelete(@RequestParam(value = "roleId", required = true) String[] roleIds){
        roleService.deleteRoles(roleIds);
        return "redirect:/sysadmin/role/list";
    }


    @RequestMapping("/tocreate")
    public String toCreate(Model model){
        return "/sysadmin/role/jRoleCreate";
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/sysadmin/role/list";
    }

    @RequestMapping("/toview")
    public String toview(String roleId, Model model){
        Role role = roleService.findOne(roleId);
        model.addAttribute("role", role);
        return "/sysadmin/role/jRoleView";
    }

    @RequestMapping("/toupdate")
    public String toupdate(String roleId, Model model){
        Role role = roleService.findOne(roleId);
        model.addAttribute("role", role);
        return "/sysadmin/role/jRoleUpdate";
    }

    @RequestMapping("/update")
    public String update(Role role){
        roleService.update(role);
        return "redirect:/sysadmin/role/list";
    }


    @RequestMapping("toRoleModule")
    public String toRoleModule(String roleId, Model model) throws JsonProcessingException {

        List<String> roleModuleList =  moduleService.findRoleModuleListByRoleId(roleId);

        List<Module> moduleList = moduleService.findAll();

        for (Module module : moduleList){
            if (roleModuleList.contains(module.getModuleId())){
                module.setChecked(true);
            }
        }
        String zTreeJSON = new ObjectMapper().writeValueAsString(moduleList);
        model.addAttribute("zTreeJson", zTreeJSON);
        model.addAttribute("roleId", roleId);
        return "sysadmin/role/jRoleModule";
    }


    @RequestMapping("saveRoleModule")
    public String saveRoleModule(String[] moduleIds, String roleId){
        roleService.saveRoleModule(moduleIds, roleId);
        return "redirect:/sysadmin/role/list";
    }

}
