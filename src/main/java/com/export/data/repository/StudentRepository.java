package com.export.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.export.data.entity.Student;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Sep 5, 2020	
 *@version 1.0
 */
public interface StudentRepository extends JpaRepository<Student, String> {

}
