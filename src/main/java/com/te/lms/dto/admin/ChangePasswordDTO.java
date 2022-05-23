package com.te.lms.dto.admin;

import lombok.Data;

@Data
public class ChangePasswordDTO {
	
	private String empId;
	private String existingPassword;
	private String newPassword;
	private String reTypeNewPassword;
	
}
