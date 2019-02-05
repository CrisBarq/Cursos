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

import com.company.demo.mappers.LevelMapper;
import com.company.demo.model.Level;

@RunWith(MockitoJUnitRunner.class)
public class LevelServiceImplTest {

	@Mock
	private LevelMapper levelMapper;

	@InjectMocks
	private LevelServiceImpl levelServiceImpl;

	private List<Level> levelList;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		levelList = new ArrayList<>();
	}

	@Test
	public void findAll() {

		Mockito.when(levelMapper.findAllLevels()).thenReturn(levelList);
		Assertions.assertEquals(levelServiceImpl.findAllLevels().size(), levelList.size());
	}

}
