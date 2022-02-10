package com.bezkoder.spring.jpa.postgresql.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jpa.postgresql.model.Department;
import com.bezkoder.spring.jpa.postgresql.repository.DepartmentRepository;
import com.example.exception.DataNotFoundException;
import com.example.exception.DuplicateDataException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Override
	public List<Department> getAllDepartments() throws DataNotFoundException {
		log.info(" Start : getAllDepartments ");
		List<Department> departmentsList = departmentRepository.findAll();
		log.info("getAllDepartments : size = " + departmentsList.size());
		if (departmentsList.size() > 0) {
			return departmentsList;
		} else {
			throw new DataNotFoundException("No Departments");
		}
	}

	@Override
	public Department createDepartment(Department department) throws DuplicateDataException, ParseException {
		log.info(" Create Department " + department.getDepartmentName());

		Optional<Department> existingDepartment = departmentRepository
				.findByDepartmentNameIgnoreCase(department.getDepartmentName());

		if (existingDepartment.isPresent()) {
			throw new DuplicateDataException("Not a valid Department . Department Name already present");
		} else {
			department = departmentRepository.save(department);

			return department;
		}
	}

	@Override
	public Department getDepartmentByDepartmentId(long departmentId) throws DataNotFoundException {
		log.info(" Get Department by DepartmentId " + departmentId);

		Optional<Department> optional = departmentRepository.findById(departmentId);
		log.info(" Is Department Exist " + optional.isPresent());

		if (optional.isPresent()) {
			Department department = optional.get();
			return department;
		} else {
			throw new DataNotFoundException("Not a valid Department Id. Department not found");
		}
	}

	@Override
	public void deleteDepartment(Long departmentId) throws DataNotFoundException {
		log.info(" Delete Department " + departmentId);

		Optional<Department> optional = departmentRepository.findById(departmentId);
		log.info(" Is Department Exist " + optional.isPresent());

		if (optional.isPresent()) {
			departmentRepository.deleteById(departmentId);
		} else {
			throw new DataNotFoundException("Not a valid Department Id. Department not found");
		}

	}

	@Override
	public Department updateDepartment(Department department) throws DataNotFoundException {
		log.info(" Update Department " + department.getDepartmentId());

		Optional<Department> optional = departmentRepository.findById(department.getDepartmentId());
		log.info(" Is Department Exist " + optional.isPresent());

		if (optional.isPresent()) {
			department.setDepartmentName(department.getDepartmentName());
			department.setEmployeeName(department.getEmployeeName());
			department.setDateOfJoining(department.getDateOfJoining());
			department = departmentRepository.save(department);

			return department;
		} else {
			throw new DataNotFoundException("Not a valid Department Id. Department not found");
		}
	}

}
