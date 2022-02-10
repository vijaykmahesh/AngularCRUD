package com.bezkoder.spring.jpa.postgresql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.bezkoder.spring.jpa.postgresql.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	public Optional<Department> findByDepartmentNameIgnoreCase(@Param("departmentName") String departmentName);

}
