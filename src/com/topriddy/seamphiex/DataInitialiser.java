package com.topriddy.seamphiex;

import java.util.logging.Logger;

import com.topriddy.seamphiex.dao.AdminDao;
import com.topriddy.seamphiex.dao.StudentDao;
import com.topriddy.seamphiex.dao.SupervisorDao;
import com.topriddy.seamphiex.entity.Admin;
import com.topriddy.seamphiex.entity.Student;
import com.topriddy.seamphiex.entity.Supervisor;

public class DataInitialiser {
	private static final Logger log = Logger.getLogger(DataInitialiser.class.getName()); 
	static{
		initWithDefaultData();
	}
	
	public static void initWithDefaultData(){
		log.info("Data Initializer.....");
		
		initAdminWithDefaultData();
		initStudentWithDefaultData();
		initSupervisorWithDefaultData();
	}
	
	private static void initAdminWithDefaultData(){
		AdminDao adminDao = new AdminDao();
		Admin admin = new Admin("admin", "password");
		if(adminDao.findByUsername(admin.getUsername()) == null){
			log.info("Admin Does Not Already Exists...now attempting to create");
			adminDao.save(admin);
			log.info("Admin Saved Successfully");
		}else{
			log.info("Admin already Exists...not recreating");
		}
	}
	
	
	private static void initStudentWithDefaultData(){
		StudentDao studentDao = new StudentDao();
		Student student = new Student("student", "password");
		if(studentDao.findByUsername(student.getUsername()) == null){
			log.info("Student Does Not Already Exists...now attempting to create");
			studentDao.save(student);
			log.info("Student Saved Successfully");
		}else{
			log.info("Student Already Exists...not recreating");
		}
	}
	
	private static void initSupervisorWithDefaultData(){
		SupervisorDao supervisorDao = new SupervisorDao();
		Supervisor supervisor = new Supervisor("supervisor", "password");
		if(supervisorDao.findByUsername(supervisor.getUsername()) == null){
			log.info("Supervisor Does Not Already Exists...now attempting to create");
			supervisorDao.save(supervisor);
			log.info("Supervisor Saved Successfully");
		}else{
			log.info("Supervisor Already Exists...not recreating");
		}
	}
	
}