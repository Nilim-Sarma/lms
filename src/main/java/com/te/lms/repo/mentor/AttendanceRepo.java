package com.te.lms.repo.mentor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.mentor.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer>{

}
