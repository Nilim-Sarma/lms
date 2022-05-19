package com.te.lms.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.te.lms.pojo.Mock;
import com.te.lms.pojo.Technologies;
import com.te.lms.pojo.UserInfo;
import com.te.lms.repo.BatchDetailsRepo;
import com.te.lms.repo.EmployeeRepo;
import com.te.lms.repo.EmployeeRequestRepo;
import com.te.lms.repo.MentorRepo;
import com.te.lms.repo.MockRepo;
import com.te.lms.repo.TechnologiesRepo;
import com.te.lms.repo.UserInfoRepo;
import com.te.lms.utility.EmailServicesLms;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Autowired
	private BatchDetailsRepo batchRepo;

	@Autowired
	private EmployeeRequestRepo requestRepo;

	@Autowired
	private MentorRepo mentorRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private TechnologiesRepo technologiesRepo;

	@Autowired
	private EmailServicesLms emailService;

	@Autowired
	private MockRepo mockRepo;

	@Autowired
	private UserInfoRepo userInfoRepo;

	@Override
	public BatchDetails addBatch(BatchDTO details) {
		Mentor mentor = mentorRepo.findById(details.getMentorId()).get();
		List<Technologies> technologies = technologiesRepo.findAllById(details.getTechId());
		BatchDetails batchDetails = new BatchDetails();
		BeanUtils.copyProperties(details, batchDetails);
		batchDetails.setTechnologies(technologies);
		batchDetails.setMentor(mentor);
		BatchDetails save = batchRepo.save(batchDetails);
		if (save == null) {
			throw new RuntimeException();
		}
		return save;
	}

	@Override
	public BatchDetails update(BatchDTO details) {
		BatchDetails existing = batchRepo.findById(details.getBatchId()).get();
		if (existing == null) {
			throw new RuntimeException();
		}
		Mentor mentor = mentorRepo.findById(details.getMentorId()).get();

		List<Technologies> list = new ArrayList<Technologies>();
		for (Integer techId : details.getTechId()) {
			Technologies technologies = technologiesRepo.findById(techId).get();
			list.add(technologies);
		}
		existing.setBatchName(details.getBatchName());
		existing.setEndDate(details.getEndDate());
		existing.setMentor(mentor);
		existing.setStatus(details.getStatus());
		existing.setTechnologies(list);
		return batchRepo.save(existing);
	}

	@Override
	@Transactional
	public void deleteBatch(Integer id) {
		batchRepo.deleteById(id);
	}

	@Override
	public Mentor addMentor(AddMentorDTO mentordetails) {
		Mentor findByEmpId = mentorRepo.findByEmpId(mentordetails.getEmpId());
		if (findByEmpId == null) {
			Mentor mentor = new Mentor();
			mentor.setEmpId(mentordetails.getEmpId());
			mentor.setEmail(mentordetails.getEmailId());
			mentor.setMentorName(mentordetails.getName());
			mentor.setStatus("Active");
			List<Technologies> findAllById = technologiesRepo.findAllById(mentordetails.getTechId());
			mentor.setTechnologies(findAllById);
			String password = emailService.sendPassword(mentordetails.getEmailId());
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(mentor.getEmpId());
			userInfo.setPassword(password);
			userInfo.setAuthorities("ROLE_MENTOR");
			userInfoRepo.save(userInfo);
			mentorRepo.save(mentor);
			return mentor;
		} else {
			findByEmpId.setEmpId(mentordetails.getEmpId());
			findByEmpId.setEmail(mentordetails.getEmailId());
			findByEmpId.setMentorName(mentordetails.getName());
			findByEmpId.setStatus(mentordetails.getStatus());
			List<Technologies> findAllById = technologiesRepo.findAllById(mentordetails.getTechId());
			findByEmpId.setTechnologies(findAllById);
			return mentorRepo.save(findByEmpId);
		}
	}

	@Override
	public List<BatchDetailsAdminDTO> getAllBatchDetails() {
		List<BatchDetails> batchDetails = batchRepo.findAll();
		if (batchDetails == null) {
			throw new RuntimeException("No batchs to display");
		}
		List<BatchDetailsAdminDTO> list = new ArrayList<>();
		batchDetails.stream().forEach(b -> {
			BatchDetailsAdminDTO dto = new BatchDetailsAdminDTO();
			BeanUtils.copyProperties(b, dto);
			dto.setMentorName(b.getMentor().getMentorName());
			dto.setTechnologies(b.getTechnologies());
			list.add(dto);
		});
		return list;
	}

	@Override
	public List<Mentor> getAllMentorDetails() {
		List<Mentor> mentorDetails = mentorRepo.findAll();

		if (mentorDetails == null) {
			throw new RuntimeException();
		}

		List<Mentor> activeMentors = new ArrayList<Mentor>();
		for (Mentor mentor : mentorDetails) {
			if (mentor.getStatus().equalsIgnoreCase("Active")) {
				activeMentors.add(mentor);
			}
		}
		return activeMentors;

	}

	@Override
	public List<Technologies> getAllTechnologies() {
		List<Technologies> technologies = technologiesRepo.findAll();
		if (technologies == null) {
			throw new RuntimeException();
		}
		return technologies;
	}

	@Override
	public List<DropDownDTO> getMentorName() {
		List<Mentor> mentor = mentorRepo.findAll();
		List<DropDownDTO> list = new ArrayList<>();
		mentor.stream().forEach(m -> {
			list.add(new DropDownDTO(m.getId(), m.getMentorName()));
		});
		log.info("" + list);
		return list;
	}

	@Override
	public List<EmpRequestResDTO> getEmpRequest() {
		List<EmployeeRequest> all = requestRepo.findAll();
		List<Integer> empId = new ArrayList<>();
		all.stream().forEach(e -> empId.add(e.getEmpId()));
		List<Employee> empList = employeeRepo.findAllById(empId);
		List<EmpRequestResDTO> resp = new ArrayList<>();
		empList.stream().forEach(e -> {
			EmpRequestResDTO empRequestResDTO = new EmpRequestResDTO();
			empRequestResDTO.setEmpId(e.getId());
			empRequestResDTO.setEmpName(e.getEmpName());
			empRequestResDTO.setContactNo(e.getContact().get(0).getContactNumber());
			empRequestResDTO.setExperience((e.getExp() == null) ? ("Fresher") : ("Experience"));
			empRequestResDTO
					.setPercentage(e.getEducationDetails().get(e.getEducationDetails().size() - 1).getPercentage());
			empRequestResDTO.setYop(e.getEducationDetails().get(e.getEducationDetails().size() - 1).getYop());
			resp.add(empRequestResDTO);
		});
		return resp;
	}

	@Override
	@Transactional
	public List<Employee> approveRequest(RequestApproveDTO approve) {
		List<Employee> findAllById = employeeRepo.findAllById(approve.getEmployeesId());
		BatchDetails batchDetails = batchRepo.getById(approve.getBatchId());
		List<Employee> employees = batchDetails.getEmployees();
		employees.addAll(findAllById);
		batchDetails.setEmployees(employees);
		batchRepo.save(batchDetails);
		findAllById.stream().forEach(e -> {
			String sendPassword = emailService.sendPassword(e.getEmail());
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(e.getEmpId());
			userInfo.setPassword(sendPassword);
			userInfo.setAuthorities("ROLE_EMPLOYEE");
			userInfoRepo.save(userInfo);
		});
		requestRepo.deleteByEmpIdIn(approve.getEmployeesId());
		return findAllById;
	}

	@Override
	@Transactional
	public void deleteMentor(String id) {
		Mentor mentorDetails = mentorRepo.findByEmpId(id);
		Mock findByPanel = mockRepo.findByPanel(mentorDetails);
		if (findByPanel != null) {
			mockRepo.delete(findByPanel);
		}
		if (mentorDetails.getStatus() == null) {
			throw new RuntimeException("Mentor Not present");
		}
		mentorDetails.setStatus("Inactive");
		mentorRepo.save(mentorDetails);
	}

	@Override
	public List<EmployeeRequest> rejectRequest(RejectDTO reject) {
		List<EmployeeRequest> findAllById = requestRepo.findAllById(reject.getIds());
		findAllById.stream().forEach(e -> e.setReason(reject.getReason()));
		findAllById.stream().forEach(e -> requestRepo.save(e));
		return findAllById;
	}

	@Override
	public List<DropDownDTO> getBatchId() {
		List<BatchDetails> findAll = batchRepo.findAll();
		List<DropDownDTO> listofdrop = new ArrayList<>();
		findAll.stream().forEach(b -> {
			DropDownDTO dto = new DropDownDTO();
			dto.setId(b.getId());
			dto.setName(b.getBatchName());
			listofdrop.add(dto);
		});
		return listofdrop;
	}

}
