package com.te.lms.repo.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.pojo.admin.EmployeeRequest;

@Repository
public interface EmployeeRequestRepo extends JpaRepository<EmployeeRequest, Integer>{

	public void deleteByEmpIdIn(List<Integer> empId);
}
