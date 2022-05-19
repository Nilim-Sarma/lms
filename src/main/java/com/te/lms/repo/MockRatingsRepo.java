package com.te.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.pojo.MockRatings;

public interface MockRatingsRepo extends JpaRepository<MockRatings, Integer>{

}
