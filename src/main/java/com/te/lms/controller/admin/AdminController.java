package com.te.lms.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.ResponseDTO;
import com.te.lms.dto.admin.BatchDTO;
import com.te.lms.dto.admin.BatchDetailsAdminDTO;
import com.te.lms.dto.admin.DropDownDTO;
import com.te.lms.dto.admin.RejectDTO;
import com.te.lms.dto.admin.RequestApproveDTO;
import com.te.lms.dto.employee.EmpRequestResDTO;
import com.te.lms.dto.mentor.AddMentorDTO;
import com.te.lms.pojo.admin.BatchDetails;
import com.te.lms.pojo.admin.EmployeeRequest;
import com.te.lms.pojo.employee.Employee;
import com.te.lms.pojo.employee.Technologies;
import com.te.lms.pojo.mentor.Mentor;
import com.te.lms.service.admin.AdminService;

@RestController
@RequestMapping("/lms/v1/admin/")
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	AdminService service;

	@PostMapping("/batch")
	public ResponseEntity<ResponseDTO> addBatch(@RequestBody BatchDTO details) {
		BatchDetails addBatch = service.addBatch(details);
		return new ResponseEntity<>(new ResponseDTO(false, "Success", addBatch), HttpStatus.OK);
	}

	@PutMapping("/batch")
	public ResponseEntity<ResponseDTO> updateBatch(@RequestBody BatchDTO details) {
		return new ResponseEntity<>(new ResponseDTO(false, "Success", service.update(details)), HttpStatus.OK);
	}

	@DeleteMapping("/batch/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) {
		if (id == null) {
			throw new RuntimeException();
		}
		service.deleteBatch(id);
		return new ResponseEntity<>(new ResponseDTO(false, "Deleted the batch successfully", null), HttpStatus.OK);
	}

	@PostMapping("/mentor")
	public ResponseEntity<ResponseDTO> addMentor(@RequestBody AddMentorDTO mentorDetails) {
		Mentor addMentor = service.addMentor(mentorDetails);
		ResponseDTO body = new ResponseDTO(false, "Added mentor Successfully", addMentor);
		return new ResponseEntity<ResponseDTO>(body, HttpStatus.OK);
	}

	@GetMapping("/batch")
	public ResponseEntity<ResponseDTO> getAllBatchDetails() {
		List<BatchDetailsAdminDTO> allBatchDetails = service.getAllBatchDetails();
		return new ResponseEntity<>(new ResponseDTO(false, "All batch details fetched Successfully", allBatchDetails),
				HttpStatus.OK);
	}

	@GetMapping("/mentor")
	public ResponseEntity<ResponseDTO> getAllMentorDetails() {
		List<Mentor> allMentorDetails = service.getAllMentorDetails();
		return new ResponseEntity<>(new ResponseDTO(false, "All metnor Details fetched Successfully", allMentorDetails),
				HttpStatus.OK);
	}

	@GetMapping("/technologies")
	public ResponseEntity<ResponseDTO> getAllTechnologies() {
		List<Technologies> allTechnologies = service.getAllTechnologies();
		return new ResponseEntity<>(new ResponseDTO(false, "All technologies fetched Succesfully", allTechnologies),
				HttpStatus.OK);
	}

	@GetMapping("/mentor/values")
	public ResponseEntity<ResponseDTO> getMentorDropDown() {
		List<DropDownDTO> mentorName = service.getMentorName();
		return new ResponseEntity<>(new ResponseDTO(false, "All mentor name successfully fetched", mentorName),
				HttpStatus.OK);
	}

	@GetMapping("/request")
	public ResponseEntity<ResponseDTO> getRequestList() {
		List<EmpRequestResDTO> empRequest = service.getEmpRequest();
		return new ResponseEntity<>(new ResponseDTO(false, "Fetched all employee request", empRequest), HttpStatus.OK);
	}

	@PostMapping("/approve")
	public ResponseEntity<ResponseDTO> approveRequest(RequestApproveDTO approve) {
		List<Employee> approveRequest = service.approveRequest(approve);
		return new ResponseEntity<>(new ResponseDTO(false, "Successfully added employees to batch", approveRequest),
				HttpStatus.OK);
	}

	@PostMapping("/reject")
	public ResponseEntity<ResponseDTO> rejectRequest(@RequestBody RejectDTO reject) {
		List<EmployeeRequest> request = service.rejectRequest(reject);
		return new ResponseEntity<>(new ResponseDTO(false, "Rejected the request", request), HttpStatus.OK);

	}

	@PutMapping("/mentor/{id}")
	public ResponseEntity<ResponseDTO> softDeleteMentor(@PathVariable String id) {
		if (id == null) {
			throw new RuntimeException("Id is null");
		}
		service.deleteMentor(id);
		return new ResponseEntity<>(new ResponseDTO(false, "Mentor deleted successfully", null), HttpStatus.OK);
	}

	@GetMapping("/batchid")
	public ResponseEntity<ResponseDTO> getBatchId() {
		List<DropDownDTO> batchId = service.getBatchId();
		return new ResponseEntity<>(new ResponseDTO(false, "Drop Down of bacth Ids", batchId), HttpStatus.OK);
	}
}
