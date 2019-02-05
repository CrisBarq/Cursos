package com.company.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.company.demo.model.Level;

@Mapper
public interface LevelMapper {

	@Select("SELECT * FROM LEVELS")
	@Results(value = { @Result(column = "ID_LEVEL", property = "idLevel", javaType = Long.class),
			@Result(column = "DES_LEVEL", property = "desLevel", javaType = String.class) })
	public List<Level> findAllLevels();

	@Select("SELECT * FROM LEVELS WHERE DES_LEVEL = #{desLevel}")
	@Results(value = { @Result(column = "ID_LEVEL", property = "idLevel", javaType = Long.class),
			@Result(column = "DES_LEVEL", property = "desLevel", javaType = String.class) })
	public Level findLevelByDes(String desLevel);
}
