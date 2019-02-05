package com.company.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.company.demo.model.Course;

@Mapper
public interface CourseMapper {

	@Select("SELECT * FROM COURSES c " + "JOIN TEACHERS t on c.ID_TEACHER = t.ID_TEACHER "
			+ "JOIN LEVELS l on l.ID_LEVEL = c.ID_LEVEL ORDER BY C.TITLE ")
	@Results(value = {
			@Result(column = "ID_COURSE", property = "idCourse", javaType = Long.class),
			@Result(column = "TITLE", property = "title", javaType = String.class),
			@Result(column = "HOURS", property = "hours", javaType = Integer.class),
			@Result(column = "LOG_ACTIVE", property = "logActive", javaType = Boolean.class),
			@Result(column = "NAME", property = "teacher.name", javaType = String.class),
			@Result(column = "DES_LEVEL", property = "level.desLevel", javaType = String.class) })
	public List<Course> selectAllCourses();

	@Select("SELECT * FROM COURSES c WHERE c.TITLE = #{title}")
	@Results(value = { @Result(column = "ID_COURSE", property = "idCourse", javaType = Long.class),
			@Result(column = "TITLE", property = "title", javaType = String.class),
			@Result(column = "HOURS", property = "hours", javaType = Integer.class),
			@Result(column = "LOG_ACTIVE", property = "logActive", javaType = Boolean.class),
			@Result(column = "NAME", property = "teacher.name", javaType = String.class),
			@Result(column = "DES_LEVEL", property = "level.desLevel", javaType = String.class) })
	public Course findByTitle(String title);

	@Insert("INSERT INTO COURSES (TITLE, HOURS, ID_LEVEL, ID_TEACHER, LOG_ACTIVE) "
			+ "VALUES (#{title}, #{hours}, #{level.idLevel}, #{teacher.idTeacher}, #{logActive})")
	public void createCourse(Course course);
}
