package com.company.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.demo.mappers.TeacherMapper;
import com.company.demo.model.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

	@Autowired
	TeacherMapper teacherMapper;

	/**
	 * Recupera todos los profesores
	 */
	@Override
	public List<Teacher> findAllTeachers() {
		logger.debug("Init findAllTeachers");
		List<Teacher> teacherList = null;

		try {

			// Se recuperan los profesores
			teacherList = teacherMapper.findAllTeachers();

			logger.debug("Finish findAllTeachers");
		} catch (Exception e) {
			logger.error("Error in findAllTeachers");
			throw e;
		}

		return teacherList;
	}

}
