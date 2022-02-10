package com.bezkoder.spring.jpa.postgresql.service;

import java.text.ParseException;
import java.util.List;

import com.bezkoder.spring.jpa.postgresql.model.Department;
import com.example.exception.DataNotFoundException;
import com.example.exception.DuplicateDataException;

public interface DepartmentService {

	public List<Department> getAllDepartments() throws DataNotFoundException;

	public void deleteDepartment(Long departmentId) throws DataNotFoundException;

	public Department updateDepartment(Department department) throws DataNotFoundException;

	Department getDepartmentByDepartmentId(long departmentId) throws DataNotFoundException;

	Department createDepartment(Department department)
			throws DuplicateDataException, ParseException;

}
