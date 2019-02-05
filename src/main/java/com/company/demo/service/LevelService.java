package com.company.demo.service;

import java.util.List;

import com.company.demo.model.Level;

public interface LevelService {

	/**
	 * Recupera todos los niveles
	 *
	 * @return
	 */
	public List<Level> findAllLevels();

}
