package com.bezkoder.spring.jpa.postgresql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jpa.postgresql.model.File;

@Repository
public interface FileRepository  extends JpaRepository<File, String> {
	 Optional<File> findByName(String name);
}
