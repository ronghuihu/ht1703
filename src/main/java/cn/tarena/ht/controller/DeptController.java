package cn.tarena.ht.controller;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sysadmin/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/list")
	public String findList(Model model) {
		model.addAttribute("deptList" , deptService.findDept());
		System.out.println(deptService.findDept());
		return "/sysadmin/dept/jDeptList";
	}
	
	@RequestMapping("/stop")
	public String toStop(@RequestParam(value="deptId", required = true) String[] deptIds) {
		if (deptIds != null) {
			int state = 0;
			deptService.toUpdateState(deptIds, state);;
		}
		return "redirect:/sysadmin/dept/list";
	}
	@RequestMapping("/start")
	public String toStart(@RequestParam(value = "deptId", required = true)String[] deptIds) {
		int state = 1;
		deptService.toUpdateState(deptIds, state);;
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/delete")
	public String deleteDepts(@RequestParam(value = "deptId", required = true)String[] deptIds) {
		deptService.DeptdeleteDepts(deptIds);;
		return "redirect:/sysadmin/dept/list";
	}
	
	
	@RequestMapping("/tocreate")
	public String toCreate(Model model) {
		List<Dept> deptList = deptService.findDept();
		model.addAttribute("deptList", deptList);
		return "/sysadmin/dept/jDeptCreate";
	}
	
	
	@RequestMapping("/toupdate")
	public String toUpdate(String deptId, Model model) {
		Dept dept = deptService.findOne(deptId);
		model.addAttribute("dept", dept);
		List<Dept> deptList = deptService.findDept();
		model.addAttribute("deptList", deptList);
		return "/sysadmin/dept/jDeptUpdate";
	}
	
	
	@RequestMapping("/insert")
	public String toInsert(Dept dept) {
		deptService.insert(dept);
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/toview")
	public String toView(String deptId, Model model) {
		Dept dept = deptService.findOne(deptId);
		model.addAttribute("dept", dept);
		List<Dept> deptList = deptService.findDept();
		model.addAttribute("deptList", deptList);
		return "/sysadmin/dept/jDeptView";
	}
	
	
	
}
