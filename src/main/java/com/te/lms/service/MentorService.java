package com.te.lms.service;

import java.util.List;

import com.te.lms.dto.AddMockDTO;
import com.te.lms.dto.AddMockRatingsDTO;
import com.te.lms.dto.AttendanceDTO;
import com.te.lms.dto.ChangePasswordDTO;
import com.te.lms.dto.DropDownDTO;
import com.te.lms.dto.EmployeeStatusDTO;
import com.te.lms.dto.MentorBatchResDto;
import com.te.lms.pojo.Employee;
import com.te.lms.pojo.Mock;
import com.te.lms.pojo.MockRatings;

public interface MentorService {
	
	public List<Employee> getAllEmployee(String batchName);

	public List<MockRatings> getEmployeeDetails(String name);

	public Mock createMock(AddMockDTO mock);

	public MockRatings giveMockRatings(AddMockRatingsDTO ratings);

	public List<DropDownDTO> getBatchNameByMentor(String mentorName);

	public List<EmployeeStatusDTO> getstatus(Integer batchId);

	public List<MentorBatchResDto> getAllBatch(Integer mentorId);

	public String changePassword(ChangePasswordDTO dto);

	public void giveAttendance(AttendanceDTO attendance);
}
