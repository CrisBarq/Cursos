package com.company.demo.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.demo.model.Course;
import com.company.demo.service.CourseService;
import com.company.demo.service.LevelService;
import com.company.demo.service.TeacherService;

@Named
@ViewScoped
public class CourseBean implements Serializable {
	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(CourseBean.class);

	@Autowired
	CourseService courseService;

	@Autowired
	TeacherService teacherService;

	@Autowired
	LevelService levelService;

	private List<Course> courseList;
	private Course course = new Course();

	private List<String> teacherList;
	private String teacher;

	private List<String> levelList;
	private String level;

	private UploadedFile uploadedFile;

	private String message;

	@PostConstruct
	public void init() {
		logger.debug("Init init");

		try {

			// Recupera la lista de todos los cursos activos
			courseList = courseService.findAll().stream().filter(course -> course.getLogActive() == true)
					.collect(Collectors.toList());

			logger.debug("Finish init");
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR ", e.getMessage()));
		}
	}

	public void createCourse() {
		logger.debug("Init createCourse");

		try {

			FacesContext context = FacesContext.getCurrentInstance();

			// Se crea el curso nuevo
			courseService.createCourse(this.getCourse(), teacher, level);

			// Se consulta la lista de cursos para que se actualice la lista
			init();

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success ", "Curso creado"));

			logger.debug("Finish createCourse");
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR ", e.getMessage()));
		}

	}

	/**
	 * Redirige al formulario para crear un nuevo curso y rellena las listas de
	 * profesores y niveles
	 *
	 * @return
	 */
	public String addCourse() {
		logger.debug("Init addCourse");

		try {

			// Se crea un nuevo curso
			course = new Course();

			// Recupera la lista de profesores
			teacherList = this.teacherService.findAllTeachers().stream().map(teacher -> teacher.getName())
					.collect(Collectors.toList());

			// Recupera la lista de niveles
			levelList = this.levelService.findAllLevels().stream().map(level -> level.getDesLevel())
					.collect(Collectors.toList());

			logger.debug("Finish addCourse");
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR ", e.getMessage()));
		}

		return "addCourse.xhtml";
	}

	public String printMsgFromSpring() {
		return "Prueba";
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<String> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<String> teacherList) {
		this.teacherList = teacherList;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public List<String> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<String> levelList) {
		this.levelList = levelList;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
}
