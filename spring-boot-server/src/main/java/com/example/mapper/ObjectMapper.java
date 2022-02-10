package com.example.mapper;

import com.bezkoder.spring.jpa.postgresql.DTO.DepartmentDTO;
import com.bezkoder.spring.jpa.postgresql.model.Department;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ObjectMapper {
	
	private static MapperFactory mapperFactory;
	
	static {
		ObjectMapper.mapperFactory = (MapperFactory) new DefaultMapperFactory.Builder().build();
	}
	
	
//	private static final Logger log = LoggerFactory.getLogger(ObjectMapper.class);
	
	public static MapperFacade getMapFactory() {
		return mapperFactory.getMapperFacade();
	}
	
	
	public static Department toDepartment(DepartmentDTO departmentDTO) {
		mapperFactory.classMap(DepartmentDTO.class, Department.class).byDefault().register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		System.out.println("mapper details"+mapper);
		Department dto = mapper.map(departmentDTO, Department.class);
		System.out.println("DTO details"+dto);
		return dto;
	}

	public static DepartmentDTO toDepartmentDTO(Department department) {
		mapperFactory.classMap(Department.class, DepartmentDTO.class).byDefault().register();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		DepartmentDTO dto = mapper.map(department, DepartmentDTO.class);
		return dto;
	}

}
