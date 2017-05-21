package cn.tarena.ht.service.ServiceImpl;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptMapper deptMapper;
	public List<Dept> findDept() {
		return deptMapper.findAll();
	}
	
	public void toUpdateState(String[] deptIds, int state) {
		deptMapper.updateState(deptIds, state);
	}

	public void DeptdeleteDepts(String[] deptIds) {
		deptMapper.DeptdeleteDepts(deptIds);
	}

	public Dept findOne(String deptId) {
		return deptMapper.findOne(deptId);
	}

	public void insert(Dept dept) {
		deptMapper.insert(dept);
	}
	
}
