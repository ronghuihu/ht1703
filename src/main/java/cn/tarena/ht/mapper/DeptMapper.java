package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
	
	public List<Dept> findAll();
	
	public void updateState(@Param("deptIds") String[] deptIds, @Param("state") int state);

	public void DeptdeleteDepts(String[] deptIds);

	public Dept findOne(String deptId);

	public void insert(Dept dept);
	
}
