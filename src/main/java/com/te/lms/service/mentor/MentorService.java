package com.te.lms.service.mentor;

import java.util.List;

import com.te.lms.dto.admin.ChangePasswordDTO;
import com.te.lms.dto.admin.DropDownDTO;
import com.te.lms.dto.employee.EmployeeStatusDTO;
import com.te.lms.dto.mentor.AddMockDTO;
import com.te.lms.dto.mentor.AddMockRatingsDTO;
import com.te.lms.dto.mentor.AttendanceDTO;
import com.te.lms.dto.mentor.MentorBatchResDto;
import com.te.lms.pojo.employee.Employee;
import com.te.lms.pojo.mentor.Mock;
import com.te.lms.pojo.mentor.MockRatings;

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
