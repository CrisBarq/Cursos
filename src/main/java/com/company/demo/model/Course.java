package com.company.demo.model;

import java.io.Serializable;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idCourse;
	private String title;
	private Integer hours;
	private Teacher teacher;
	private Level level;
	private Boolean logActive;

	public Course() {

	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Boolean getLogActive() {
		return logActive;
	}

	public void setLogActive(Boolean logActive) {
		this.logActive = logActive;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
