package com.export.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.export.data.entity.Student;
import com.export.data.repository.StudentRepository;
import com.export.data.service.IStudentService;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Sep 5, 2020	
 *@version 1.0
 */
@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

}
