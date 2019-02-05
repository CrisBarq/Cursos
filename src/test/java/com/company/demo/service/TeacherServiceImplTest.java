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

import com.company.demo.mappers.TeacherMapper;
import com.company.demo.model.Teacher;

@RunWith(MockitoJUnitRunner.class)
public class TeacherServiceImplTest {

	@Mock
	private TeacherMapper teacherMapper;

	@InjectMocks
	private TeacherServiceImpl teacherServiceImpl;

	private List<Teacher> teacherList;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		teacherList = new ArrayList<>();
	}

	@Test
	public void findAll() {

		Mockito.when(teacherMapper.findAllTeachers()).thenReturn(teacherList);
		Assertions.assertEquals(teacherServiceImpl.findAllTeachers().size(), teacherList.size());
	}
}
