package com.company.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.demo.mappers.CourseMapper;
import com.company.demo.mappers.LevelMapper;
import com.company.demo.mappers.TeacherMapper;
import com.company.demo.model.Course;
import com.company.demo.model.Level;
import com.company.demo.model.Teacher;

@Service
public class CourseServiceImpl implements CourseService {

	Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	CourseMapper courseMapper;

	@Autowired
	TeacherMapper teacherMapper;

	@Autowired
	LevelMapper levelMapper;

	/**
	 * Servicio que busca todos los cursos
	 */
	@Override
	public List<Course> findAll() {
		logger.debug("Init findAll");
		List<Course> courseList = null;

		try {

			// Se realiza la búsqueda
			courseList = this.courseMapper.selectAllCourses();

			logger.debug("Finish findAll");
		} catch (Exception e) {
			logger.error("Error in findAll");
			throw e;
		}
		return courseList;
	}

	/**
	 * Servicio que crea un nuevo curso
	 */
	@Override
	public void createCourse(Course course, String teacherName, String levelDes) throws Exception {
		logger.debug("Init createCourse");

		try {

			// Se busca el profesor
			Optional<Teacher> teacher = Optional.ofNullable(this.teacherMapper.findTeacherByName(teacherName));

			// Si no existe es un error
			if (!teacher.isPresent()) {
				throw new Exception("Error");
			}

			// Se añade al curso
			course.setTeacher(teacher.get());

			// Se busca el nivel
			Optional<Level> level = Optional.ofNullable(this.levelMapper.findLevelByDes(levelDes));

			// Si no existe, error
			if (!level.isPresent()) {
				throw new Exception("Error");
			}

			// Se añade al curso
			course.setLevel(level.get());

			// Se comprueba que el curso no exista
			Optional<Course> courseFound = Optional.ofNullable(this.courseMapper.findByTitle(course.getTitle()));

			if (courseFound.isPresent()) {
				throw new Exception("El curso " + course.getTitle() + " ya existe");
			}

			// Se crea el curso
			this.courseMapper.createCourse(course);

			logger.debug("Finish createCourse");
		} catch (Exception e) {
			logger.error("Error in createCourse");
			throw e;
		}

	}



}
