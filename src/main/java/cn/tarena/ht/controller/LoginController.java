package cn.tarena.ht.controller;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/27.
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/sysadmin/login/login";
    }

    /**
     *
     * */
    @RequestMapping("/login")
    public String login(String userName, String password, Model model, HttpSession session){
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            model.addAttribute("errorInfo", "用户名或密码不能为空!");
            return "/sysadmin/login/login";
        }

       /* password = MD5Hash.getMD5HashPassword(password, userName);

        User user = userService.findUserByNameAndPassword(userName, password);

        if (user == null){
            model.addAttribute("errorInfo", "用户名或密码错误!");
            return "/sysadmin/login/login";
        }else {
            //将用户对象存储到session域中
            session.setAttribute("sessionUser", user);
            return "redirect:/home.action";
        }*/

        /*====================================================*/


        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = userService.findUserByNameAndPassword(userName, password);
            session.setAttribute("sessionUser", user);
            return "redirect:/home.action";
        }catch(AuthenticationException e){
            e.printStackTrace();
            model.addAttribute("errorInfo", "用户名或密码错误!");
            return "/sysadmin/login/login";
        }
        /*=========================================================*/


        /*UsernamePasswordToken token = new UsernamePasswordToken(userName,password);

        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            //传递用户名到session域
            subject.getSession().setAttribute("username", userName);
            return "redirect:/index.jsp";
        }catch(Exception e){
            model.addAttribute("errorInfo", "用户名或密码错误!");
            return "redirect:/login.jsp";
        }*/

    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("sessionUser");
        return "redirect:/toLogin";
    }




}
