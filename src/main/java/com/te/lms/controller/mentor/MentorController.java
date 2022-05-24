package com.te.lms.controller.mentor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.ResponseDTO;
import com.te.lms.dto.admin.ChangePasswordDTO;
import com.te.lms.dto.admin.DropDownDTO;
import com.te.lms.dto.employee.EmployeeStatusDTO;
import com.te.lms.dto.mentor.AddMockDTO;
import com.te.lms.dto.mentor.AddMockRatingsDTO;
import com.te.lms.dto.mentor.AttendanceDTO;
import com.te.lms.dto.mentor.MentorBatchResDto;
import com.te.lms.pojo.mentor.Mock;
import com.te.lms.pojo.mentor.MockRatings;
import com.te.lms.service.mentor.MentorService;

@RestController
@RequestMapping("/lms/v1/mentor")
public class MentorController {

	@Autowired
	private MentorService service;

	/*
	 * Drop Down for batches
	 */
	@GetMapping("/batchname/{mentorId}")
	public ResponseEntity<ResponseDTO> getBatchName(@PathVariable String mentorId) {
		List<DropDownDTO> batchname = service.getBatchNameByMentor(mentorId);
		return new ResponseEntity<>(new ResponseDTO(false, "Batch Name of mentor fetched successfully", batchname),
				HttpStatus.OK);
	}

	/*
	 * List of employees(details) of a batch (screen 5)
	 */
	@GetMapping("/batchdetails/{batchId}")
	public ResponseEntity<ResponseDTO> getBatchDetailsOfMentor(@PathVariable Integer batchId) {
		List<EmployeeStatusDTO> getstatus = service.getstatus(batchId);
		return new ResponseEntity<>(new ResponseDTO(false,
				"Employee Details of batch fetched successfully for dashboard drop down", getstatus), HttpStatus.OK);
	}

	/*
	 * Get details of particular employee (screen 6)
	 */
	@GetMapping("/employeeDetails/{empId}")
	public ResponseEntity<ResponseDTO> getDetailsOfEmployee(@PathVariable String empId) {
		List<MockRatings> details = service.getEmployeeDetails(empId);
		return new ResponseEntity<>(new ResponseDTO(false, "Mock Rating of a employee", details), HttpStatus.OK);

	}

	/*
	 * Mock for batch screen 7
	 */
	@PostMapping("/mock")
	public ResponseEntity<ResponseDTO> addMock(@RequestBody AddMockDTO mock) {
		Mock createMock = service.createMock(mock);
		return new ResponseEntity<>(new ResponseDTO(false, "Mock created", createMock), HttpStatus.OK);
	}

	/*
	 * Give mock rating for employee screen 8
	 */
	@PostMapping("/mockRatings")
	public ResponseEntity<ResponseDTO> giveMockRatings(@RequestBody AddMockRatingsDTO ratings) {
		MockRatings giveMockRatings = service.giveMockRatings(ratings);
		return new ResponseEntity<>(new ResponseDTO(false, "Mock Ratings submitted", giveMockRatings), HttpStatus.OK);
	}

	/*
	 * List of batches that mentor has engaged screen 4
	 */
	@GetMapping("/mentorbatch/{mentorId}")
	public ResponseEntity<ResponseDTO> getAllBatchs(@PathVariable Integer mentorId) {
		List<MentorBatchResDto> allBatch = service.getAllBatch(mentorId);
		return new ResponseEntity<ResponseDTO>(
				new ResponseDTO(false, "Mentor Batch Details feteched successfully", allBatch), HttpStatus.OK);
	}

	/*
	 * Change Password Api	
	 */
	@PostMapping("/password")
	public ResponseEntity<ResponseDTO> changePassword(@RequestBody ChangePasswordDTO change) {
		String changePassword = service.changePassword(change);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(false, "Password changed successfully", changePassword),
				HttpStatus.OK);
	}
	
	@PostMapping("/attendance")
	public ResponseEntity<ResponseDTO> attendance(@RequestBody AttendanceDTO attendance){
		service.giveAttendance(attendance);
		return new ResponseEntity<>(new ResponseDTO(false, "Attendance Updated", attendance),HttpStatus.OK);
	}
}
