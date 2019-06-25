package com.spring.studentinfosys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sub_id")
	private int subId;
	
	@Column(name="sub_name")
	private String subName;
	
	@Column(name="stud_id")
	private int studentId;
	
	public Subjects() {
	}
			
	public Subjects(String subName) {
		this.subName = subName;
	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Subjects [subId=" + subId + ", subName=" + subName + "]";
	}
	
	
	
}
