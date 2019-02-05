package com.company.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.company.demo.model.Teacher;

@Mapper
public interface TeacherMapper {

	@Select("SELECT * FROM TEACHERS ORDER BY NAME")
	@Results(value = { @Result(column = "ID_TEACHER", property = "idTeacher", javaType = Long.class),
			@Result(column = "NAME", property = "name", javaType = String.class) })
	public List<Teacher> findAllTeachers();

	@Select("SELECT * FROM TEACHERS WHERE NAME = #{teacherName}")
	@Results(value = { @Result(column = "ID_TEACHER", property = "idTeacher", javaType = Long.class),
			@Result(column = "NAME", property = "name", javaType = String.class) })
	public Teacher findTeacherByName(String teacherName);
}
