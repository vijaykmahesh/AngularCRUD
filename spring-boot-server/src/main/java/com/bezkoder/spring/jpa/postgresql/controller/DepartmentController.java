package com.bezkoder.spring.jpa.postgresql.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.postgresql.model.Department;
import com.bezkoder.spring.jpa.postgresql.service.DepartmentService;
import com.example.exception.DataNotFoundException;
import com.example.exception.DuplicateDataException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("Api/services")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

	@RequestMapping(value = { "/createDepartment" }, method = { RequestMethod.POST }, produces = "application/json")
	public Department createDepartment(@RequestBody Department department)
			throws DuplicateDataException, ParseException {
		log.info("Create Department");
		try {
			return departmentService.createDepartment(department);
		} catch (DataIntegrityViolationException e) {
			if (e.getRootCause() instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicateDataException("Duplicate Department Name");
			}
			throw e;
		}
	}

	@RequestMapping(value = { "/getDepartmentByDepartmentId" }, method = {
			RequestMethod.GET }, produces = "application/json")
	public Department getDepartmentByDepartmentId(@RequestParam long departmentId) throws DataNotFoundException {
		return departmentService.getDepartmentByDepartmentId(departmentId);
	}

	@RequestMapping(value = { "/getAllDepartments" }, method = { RequestMethod.GET }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Department> getAllDepartments() throws DataNotFoundException {
		return departmentService.getAllDepartments();
	}

	@RequestMapping(value = { "/deleteDepartment" }, method = { RequestMethod.DELETE }, produces = "application/json")
	public void deleteDepartment(@RequestParam Long departmentId) throws DataNotFoundException {
		try {
			departmentService.deleteDepartment(departmentId);
		} catch (EmptyResultDataAccessException e) {
			throw new DataNotFoundException("Department Not found");
		}
	}

	@RequestMapping(value = { "/updateDepartment" }, method = { RequestMethod.PUT }, produces = "application/json")
	public Department updateDepartment(@RequestBody Department department) throws DataNotFoundException {
		if (department.getDepartmentId() != 0) {
			return departmentService.updateDepartment(department);
		} else {
			throw new DataNotFoundException("Department Not found");
		}
	}

}
