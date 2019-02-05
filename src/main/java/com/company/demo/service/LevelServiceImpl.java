package com.company.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.demo.mappers.LevelMapper;
import com.company.demo.model.Level;

@Service
public class LevelServiceImpl implements LevelService {

	Logger logger = LoggerFactory.getLogger(LevelServiceImpl.class);

	@Autowired
	LevelMapper levelMapper;

	/**
	 * Servicio que recupera todos los niveles
	 */
	@Override
	public List<Level> findAllLevels() {
		logger.debug("Init findAllLevels");
		List<Level> levelList = null;

		try {

			// Se recupera la lista de niveles
			levelList = levelMapper.findAllLevels();

			logger.debug("Finish findAllLevels");
		} catch (Exception e) {
			logger.error("Error in findAllLevels");
			throw e;
		}

		return levelList;
	}

}
