package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//转向欢迎页面
	@RequestMapping("/home")
	public String home(){
		return "/home/fmain";
	}
	
	//转向tilte标题栏页面
	@RequestMapping("/title")
	public String title(){
		return "/home/title";
	}
	
//	//转向home的左侧页面
//	@RequestMapping("/homeLeft")
//	public String homeLeft(){
//		return "/home/left";
//	}
//
//	//转向home的操作页面
//	@RequestMapping("/homeMain")
//	public String homeMain(){
//		return "/home/main";
//	}
	
//	@RequestMapping("/sysadminLeft")
//	public String sysadminLeft(){
//		return "/sysadmin/left";
//	}
//
//	@RequestMapping("/sysadminMain")
//	public String sysadminMain(){
//		return "/sysadmin/main";
//	}


	//转向左侧页面
	@RequestMapping("{moduleName}/Left")
	public String homeLeft(@PathVariable String moduleName){
		return "/"+moduleName+"/left";
	}

	//转向操作页面
	@RequestMapping("{moduleName}/Main")
	public String homeMain(@PathVariable String moduleName){
		return "/"+moduleName+"/main";
	}


}
