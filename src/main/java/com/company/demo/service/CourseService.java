package com.company.demo.service;

import java.util.List;

import com.company.demo.model.Course;

public interface CourseService {

	/**
	 * Lista de todos los cursos
	 *
	 * @return
	 */
	public List<Course> findAll();

	/**
	 * Crea un nuevo curso
	 *
	 * @param course
	 * @param teacher
	 * @param level
	 * @throws Exception
	 */
	public void createCourse(Course course, String teacher, String level) throws Exception;
}
