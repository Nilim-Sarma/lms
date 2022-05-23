package com.te.lms.service.admin;

import java.util.List;

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
