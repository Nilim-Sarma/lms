package com.te.lms.service.mentor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dto.admin.ChangePasswordDTO;
import com.te.lms.dto.admin.DropDownDTO;
import com.te.lms.dto.employee.EmployeeStatusDTO;
import com.te.lms.dto.mentor.AddMockDTO;
import com.te.lms.dto.mentor.AddMockRatingsDTO;
import com.te.lms.dto.mentor.AttendanceDTO;
import com.te.lms.dto.mentor.MentorBatchResDto;
import com.te.lms.pojo.User;
import com.te.lms.pojo.admin.BatchDetails;
import com.te.lms.pojo.employee.Employee;
import com.te.lms.pojo.employee.Technologies;
import com.te.lms.pojo.mentor.Attendance;
import com.te.lms.pojo.mentor.Mentor;
import com.te.lms.pojo.mentor.Mock;
import com.te.lms.pojo.mentor.MockRatings;
import com.te.lms.repo.TechnologiesRepo;
import com.te.lms.repo.UserInfoRepo;
import com.te.lms.repo.admin.BatchDetailsRepo;
import com.te.lms.repo.admin.MentorRepo;
import com.te.lms.repo.employee.EmployeeRepo;
import com.te.lms.repo.mentor.AttendanceRepo;
import com.te.lms.repo.mentor.MockRatingsRepo;

@Service
public class MetnorServiceImpl implements MentorService {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private MentorRepo mentorRepo;

	@Autowired
	private BatchDetailsRepo batchDetailsRepo;

	@Autowired
	private TechnologiesRepo technologiesRepo;

	@Autowired
	private UserInfoRepo userInfoRepo;
	
	@Autowired
	private MockRatingsRepo ratingsRepo;
	
	@Autowired
	private AttendanceRepo attendanceRepo;

	@Override
	public List<Employee> getAllEmployee(String batchName) {
		System.out.println("id---------------->" + batchDetailsRepo.findIdByBatchName(batchName));
		BatchDetails batch = batchDetailsRepo.findIdByBatchName(batchName);
		if (batch == null) {
			throw new RuntimeException();
		}
		return batch.getEmployees();
	}

	@Override
	public List<MockRatings> getEmployeeDetails(String empId) {

		Employee empDetails = empRepo.findByEmpId(empId);
		if (empDetails == null) {
			throw new RuntimeException("Emp id doesnot exist");
		}
		if (empDetails.getRatings().size() < 1) {
			throw new RuntimeException("No Ratings for empId");
		}
		return empDetails.getRatings();
	}

	@Override
	public Mock createMock(AddMockDTO mockdetails) {
		Mock mock = new Mock();
		mock.setMockNo(mockdetails.getMockNo());
		Technologies technologies = technologiesRepo.findById(mockdetails.getTechId()).get();
		mock.setTech(technologies);
		List<Mentor> mentorDetails = mentorRepo.findByEmpIdIn(mockdetails.getMentorId());
		mock.setPanel(mentorDetails);
		mock.setDate(mockdetails.getDateTime());
		BatchDetails batchDetails = batchDetailsRepo.findById(mockdetails.getBatchId()).get();
		batchDetails.setMock(Arrays.asList(mock));
		batchDetailsRepo.save(batchDetails);
		return mock;
	}

	@Override
	public MockRatings giveMockRatings(AddMockRatingsDTO ratings) {
		MockRatings mockRatings = new MockRatings();
		Employee employee = empRepo.findById(ratings.getEmpid()).get();
		Technologies technologies = technologiesRepo.findById(ratings.getTechId()).get();
		BeanUtils.copyProperties(ratings, mockRatings);
		mockRatings.setTech(technologies);
		mockRatings.setEmployee(employee);
		ratingsRepo.save(mockRatings);
		return mockRatings;
	}

	@Override
	public List<DropDownDTO> getBatchNameByMentor(String mentorId) {
		Mentor mentor = mentorRepo.findByEmpId(mentorId);
		List<BatchDetails> batchDetails = mentor.getBatchDetails();
		List<DropDownDTO> dropDown = new ArrayList<>();
		batchDetails.stream().forEach(b -> {
			DropDownDTO response = new DropDownDTO();
			response.setId(b.getId());
			response.setName(b.getBatchName());
			dropDown.add(response);
		});
		if (dropDown.size() < 1) {
			throw new RuntimeException();
		}
		return dropDown;
	}

	@Override
	public List<EmployeeStatusDTO> getstatus(Integer batchId) {
		BatchDetails batchDetails = batchDetailsRepo.findById(batchId).get();
		List<Employee> employees = batchDetails.getEmployees();
		if (employees.size() == 0) {
			throw new RuntimeException("No employees in the batch");
		}
		List<EmployeeStatusDTO> list = new ArrayList<>();
		employees.stream().forEach(e -> {
			EmployeeStatusDTO employeeStatusDTO = new EmployeeStatusDTO();
			employeeStatusDTO.setEmpId(e.getId());
			employeeStatusDTO.setEmpName(e.getEmpName());
			employeeStatusDTO.setMocksTaken(e.getRatings().size());
			employeeStatusDTO.setStatus(e.getStatus());
			list.add(employeeStatusDTO);
		});
		return list;
	}

	@Override
	public List<MentorBatchResDto> getAllBatch(Integer mentorId) {
		Mentor mentor = mentorRepo.findById(mentorId).get();
		List<BatchDetails> mentorBatchDetails = batchDetailsRepo.findByMentor(mentor);
		List<MentorBatchResDto> arrayList = new ArrayList<>();
		mentorBatchDetails.stream().forEach(m -> {
			MentorBatchResDto mentorBatchResDto = new MentorBatchResDto();
			mentorBatchResDto.setBatchId(m.getId());
			mentorBatchResDto.setBatchName(m.getBatchName());
			mentorBatchResDto.setBatchStrength(m.getEmployees().stream().count());
			mentorBatchResDto.setStartDate(m.getStartDate());
			mentorBatchResDto.setEndDate(m.getEndDate());
			mentorBatchResDto.setStatus(m.getStatus());
			List<String> list = new ArrayList<String>();
			m.getTechnologies().stream().forEach(t -> {
				list.add(t.getTech());
			});
			mentorBatchResDto.setTechnologies(list);
			arrayList.add(mentorBatchResDto);
		});
		return arrayList;
	}

	

	@Override
	public String changePassword(ChangePasswordDTO dto) {
		User userDetails = userInfoRepo.findByUserName(dto.getEmpId());
		if (userDetails == null) {
			throw new RuntimeException("No user with the Username");
		}
		if (dto.getExistingPassword().equals(userDetails.getPassword())
				&& dto.getNewPassword().equals(dto.getReTypeNewPassword())) {
			userDetails.setPassword(dto.getNewPassword());
			userInfoRepo.save(userDetails);
			return dto.getNewPassword();
		}else {
			return "Password Did not update";
		}
	}

	@Override
	public void giveAttendance(AttendanceDTO attendance) {
		Attendance attendanceDetails = new Attendance();
		BeanUtils.copyProperties(attendance, attendanceDetails);
		Employee employee = empRepo.findById(attendance.getEId()).get();
		attendanceDetails.setEmployee(employee);
		attendanceRepo.save(attendanceDetails);
	}

}
