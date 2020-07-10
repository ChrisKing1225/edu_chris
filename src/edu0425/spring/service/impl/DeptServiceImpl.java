package edu0425.spring.service.impl;

import java.util.List;

import edu0425.spring.dao.DeptDAO;
import edu0425.spring.dao.impl.DeptDAOImpl;
import edu0425.spring.service.DeptService;
import edu0425.spring.vo.DeptInfo;

public class DeptServiceImpl implements DeptService {
	
	private DeptDAO deptDAO;

	@Override
	public List<DeptInfo> getDeptList() {
		deptDAO = new DeptDAOImpl();
		return deptDAO.getDeptList();
	}

	@Override
	public DeptInfo getDeptById(Integer deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getDeptCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
