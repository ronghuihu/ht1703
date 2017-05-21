package cn.tarena.ht.service;

import cn.tarena.ht.pojo.Dept;

import java.util.List;

public interface DeptService {

	public List<Dept> findDept();
	
	public void toUpdateState(String[] deptIds, int state);

	public void DeptdeleteDepts(String[] deptIds);

	public Dept findOne(String deptId);

	public void insert(Dept dept);
}
