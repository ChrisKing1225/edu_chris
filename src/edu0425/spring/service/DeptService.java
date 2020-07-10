package edu0425.spring.service;

import java.util.List;

import edu0425.spring.vo.DeptInfo;

public interface DeptService {

	List<DeptInfo> getDeptList();
	
	DeptInfo getDeptById(Integer deptno);
	
	Integer getDeptCount();
}
