package cn.tarena.ht.controller;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sysadmin/user/")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @Resource
    private DeptService deptService;


    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private RoleService roleService;
    @RequestMapping("/list")
	public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "/sysadmin/user/jUserList";
    }

    @RequestMapping("/tocreate")
    public String toCreate(Model model){
	    List<Dept> deptList = deptService.findDept();
	    model.addAttribute("deptList", deptList);
	    List<UserInfo> managerList = userInfoMapper.findAll();
	    model.addAttribute("managerList", managerList);
        return "/sysadmin/user/jUserCreate";
    }

    @RequestMapping("/save")
    public String saveUser(User user){
        userService.saveUser(user);
        return "/sysadmin/user/list";
    }


    @RequestMapping("userRole")
    public String toRoleUser(@RequestParam(value = "userId", required = true) String userId, Model model) throws JsonProcessingException {
        List<Role> userRoleList = userService.findRoleByUserId(userId);
        List<Role> roleList = roleService.findAll();
        for(Role role : roleList){
//            if (userRoleList.contains(role.getRoleId())){
//                role.setChecked(true);
//            }
            for (Role role1 : userRoleList){
                if (role1.getRoleId().equals(role.getRoleId())){
                    role.setChecked(true);
                }
            }
        }
        String aTreeJSON = new ObjectMapper().writeValueAsString(roleList);
        System.out.println(aTreeJSON);
        model.addAttribute("zTreeJson", aTreeJSON);
        model.addAttribute("userId", userId);
        return "/sysadmin/user/jUserRole";
    }

    @RequestMapping("saveUserRole")
    public String saveUserRole(String[] roleIds, String userId){
        userService.saveUserRole(roleIds, userId);
        System.out.println(roleIds);
        return "redirect:/sysadmin/user/list";
    }




}
