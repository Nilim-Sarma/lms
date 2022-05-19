package com.te.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Integer>{

}
