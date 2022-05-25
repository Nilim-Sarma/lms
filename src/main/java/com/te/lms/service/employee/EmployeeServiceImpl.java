package com.te.lms.service.employee;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dto.admin.ChangePasswordDTO;
import com.te.lms.dto.employee.AddEmployeeDTO;
import com.te.lms.pojo.User;
import com.te.lms.pojo.admin.EmployeeRequest;
import com.te.lms.pojo.employee.Employee;
import com.te.lms.pojo.employee.Technologies;
import com.te.lms.pojo.mentor.MockRatings;
import com.te.lms.repo.TechnologiesRepo;
import com.te.lms.repo.UserInfoRepo;
import com.te.lms.repo.admin.EmployeeRequestRepo;
import com.te.lms.repo.employee.EmployeeRepo;
import com.te.lms.utility.EmailServicesLms;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private TechnologiesRepo technologiesRepo;

	@Autowired
	private EmployeeRequestRepo requestRepo;

	@Autowired
	private EmailServicesLms emailServices;

	@Autowired
	private UserInfoRepo userInfoRepo;

	@Override
	public Employee addEmployee(AddEmployeeDTO employeedetails) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeedetails, employee);
		employee.setStatus("Pending");
		String password = emailServices.sendPassword(employee.getEmail());
		Employee save = empRepo.save(employee);
		User userInfo = new User();
		userInfo.setUserName(employeedetails.getEmpId());
		userInfo.setPassword(password);
		userInfo.setAuthorities("ROLE_EMPLOYEE");
		userInfoRepo.save(userInfo);
		if (save == null) {
			throw new RuntimeException();
		}
		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setEmpId(save.getId());
		requestRepo.save(employeeRequest);
		return save;
	}

	@Override
	public List<MockRatings> getMockDetails(String name) {
		Employee findByEmpName = empRepo.findByEmpName(name);
		List<MockRatings> ratings = findByEmpName.getRatings();
		System.out.println("mock rating ==========> " + ratings);
		if (ratings == null) {
			throw new RuntimeException();
		}
		return ratings;
	}

	@Override
	public Employee getDetails(String name) {
		Employee empName = empRepo.findByEmpName(name);
		if (empName.getStatus().equals("Active")) {
			return empName;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public Employee updateEmployeeDetails(AddEmployeeDTO employee, Integer id) {
		Employee empDetails = empRepo.findById(id).get();
		BeanUtils.copyProperties(employee, empDetails);
		Employee employee2 = empRepo.save(empDetails);
		return employee2;
	}

	@Override
	public String changePassword(ChangePasswordDTO changePasswordDTO) {
		User userDetails = userInfoRepo.findByUserName(changePasswordDTO.getEmpId());
		if (userDetails == null) {
			throw new RuntimeException("No user with the Username");
		}
		if (changePasswordDTO.getExistingPassword().equals(userDetails.getPassword())
				&& changePasswordDTO.getNewPassword().equals(changePasswordDTO.getReTypeNewPassword())) {
			userDetails.setPassword(changePasswordDTO.getNewPassword());
			userInfoRepo.save(userDetails);
			return changePasswordDTO.getNewPassword();
		} else {
			return "Password Did not update";
		}
	}

}
