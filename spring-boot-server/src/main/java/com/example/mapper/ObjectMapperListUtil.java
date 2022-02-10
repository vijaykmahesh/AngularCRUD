package com.example.mapper;

import java.util.ArrayList;
import java.util.List;

import com.bezkoder.spring.jpa.postgresql.DTO.DepartmentDTO;
import com.bezkoder.spring.jpa.postgresql.model.Department;

import ma.glasnost.orika.MapperFacade;

public class ObjectMapperListUtil {
	
	final static MapperFacade mapper = ObjectMapper.getMapFactory();

	public static List<DepartmentDTO> mapDepartmentList(List<Department> departments) {

		List<DepartmentDTO> dtos = new ArrayList<DepartmentDTO>();
		
		System.out.println("::::::::::departments:::::::::"+departments.size());

		for (Department action : departments) {
			DepartmentDTO dto = mapper.map(action, DepartmentDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}
}
