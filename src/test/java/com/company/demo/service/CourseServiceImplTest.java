package com.company.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.demo.mappers.CourseMapper;
import com.company.demo.mappers.LevelMapper;
import com.company.demo.mappers.TeacherMapper;
import com.company.demo.model.Course;
import com.company.demo.model.Level;
import com.company.demo.model.Teacher;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

	@Mock
	private CourseMapper courseMapper;

	@Mock
	private TeacherMapper teacherMapper;

	@Mock
	private LevelMapper levelMapper;

	@InjectMocks
	private CourseServiceImpl courseServiceImpl;

	private List<Course> courseList;
	private Course course;
	private Teacher teacher;
	private Level level;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		courseList = new ArrayList<>();

		course = new Course();
		course.setIdCourse(1L);
		course.setTitle("Ionic");

		teacher = new Teacher();
		teacher.setIdTeacher(1L);

		level = new Level();
		level.setIdLevel(1L);

	}

	@Test
	public void findAll() {
		Mockito.when(courseMapper.selectAllCourses()).thenReturn(courseList);
		Assertions.assertEquals(courseServiceImpl.findAll().size(), courseList.size());
	}

	@Test
	public void createCourse() throws Exception {
		String teacherIn = "Carlos";
		String levelIn = "Basico";

		Mockito.when(teacherMapper.findTeacherByName(Mockito.anyString())).thenReturn(teacher);
		Mockito.when(levelMapper.findLevelByDes(Mockito.anyString())).thenReturn(level);

		courseServiceImpl.createCourse(course, teacherIn, levelIn);

		Mockito.verify(courseMapper, Mockito.times(1)).createCourse(Mockito.any(Course.class));
		Mockito.verify(teacherMapper, Mockito.times(1)).findTeacherByName(Mockito.anyString());
		Mockito.verify(levelMapper, Mockito.times(1)).findLevelByDes(Mockito.anyString());
	}
}
