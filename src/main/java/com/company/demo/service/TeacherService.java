package com.company.demo.service;

import java.util.List;

import com.company.demo.model.Teacher;

public interface TeacherService {

	/**
	 * Recupera todos los profesores
	 *
	 * @return
	 */
	public List<Teacher> findAllTeachers();
}
