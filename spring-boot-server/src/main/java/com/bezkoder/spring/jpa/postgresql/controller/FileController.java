package com.bezkoder.spring.jpa.postgresql.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bezkoder.spring.jpa.postgresql.model.File;
import com.bezkoder.spring.jpa.postgresql.model.ResponseFile;
import com.bezkoder.spring.jpa.postgresql.service.FileStorageService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {

	@Autowired
	private FileStorageService storageService;

	@PostMapping("/upload/{departmentId}")
	public ResponseEntity<File> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable int departmentId) {

		File storedFile = new File();
		try {
			storedFile = storageService.store(file, departmentId);

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(storedFile.getId()).toUriString();

			storedFile.setUrl(fileDownloadUri);

			return ResponseEntity.status(HttpStatus.OK).body(storedFile);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(storedFile);
		}
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		File file = storageService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
				.body(file.getData());
	}

	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(dbFile.getId()).toUriString();

			return new ResponseFile(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}
