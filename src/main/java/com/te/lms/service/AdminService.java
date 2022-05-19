package com.te.lms.service;

import java.util.List;

import com.te.lms.dto.BatchDTO;
import com.te.lms.dto.AddMentorDTO;
import com.te.lms.dto.BatchDetailsAdminDTO;
import com.te.lms.dto.DropDownDTO;
import com.te.lms.dto.EmpRequestResDTO;
import com.te.lms.dto.RejectDTO;
import com.te.lms.dto.RequestApproveDTO;
import com.te.lms.pojo.BatchDetails;
import com.te.lms.pojo.Employee;
import com.te.lms.pojo.EmployeeRequest;
import com.te.lms.pojo.Mentor;
import com.te.lms.pojo.Technologies;

public interface AdminService {
	
	public BatchDetails addBatch(BatchDTO details);

	public BatchDetails update(BatchDTO details);

	public void deleteBatch(Integer id);

	public Mentor addMentor(AddMentorDTO mentor);

	public List<BatchDetailsAdminDTO> getAllBatchDetails();

	public List<Mentor> getAllMentorDetails();

	public List<Technologies> getAllTechnologies();

	public List<DropDownDTO> getMentorName();

	public List<EmpRequestResDTO> getEmpRequest();

	public List<Employee> approveRequest(RequestApproveDTO approve);

	public void deleteMentor(String id);

	public List<EmployeeRequest> rejectRequest(RejectDTO reject);

	public List<DropDownDTO> getBatchId();
	
}
