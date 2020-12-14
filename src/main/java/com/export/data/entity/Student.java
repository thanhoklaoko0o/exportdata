package com.export.data.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Sep 5, 2020	
 *@version 1.0
 */
@Entity
@Data
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "rollno")
	private String rollno;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "birthday")
	private Date birthday;
	
}
