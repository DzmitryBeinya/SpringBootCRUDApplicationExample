package com.websystique.springboot.controller;

import java.util.List;

import com.websystique.springboot.model.Student;
import com.websystique.springboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springboot.model.User;
import com.websystique.springboot.service.UserService;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class  RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

//	@Autowired
//	UserService userService; //Service which will do all data retrieval/manipulation work

	@Autowired
	StudentService studentService;
//	// -------------------Retrieve All Users---------------------------------------------
//
//	@RequestMapping(value = "/user/", method = RequestMethod.GET)
//	public ResponseEntity<List<User>> listAllUsers() {
//		List<User> users = userService.findAllUsers();
//		if (users.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//			// You many decide to return HttpStatus.NOT_FOUND
//		}
//		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//	}
//
//	// -------------------Retrieve Single User------------------------------------------
//
//	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
//		logger.info("Fetching User with id {}", id);
//		User user = userService.findById(id);
//		if (user == null) {
//			logger.error("User with id {} not found.", id);
//			return new ResponseEntity(new CustomErrorType("User with id " + id
//					+ " not found"), HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//	}
//
//	// -------------------Create a User-------------------------------------------
//
//	@RequestMapping(value = "/user/", method = RequestMethod.POST)
//	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//		logger.info("Creating User : {}", user);
//
//		if (userService.isUserExist(user)) {
//			logger.error("Unable to create. A User with name {} already exist", user.getName());
//			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " +
//			user.getName() + " already exist."),HttpStatus.CONFLICT);
//		}
//		userService.saveUser(user);
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
//		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//	}
//
//	// ------------------- Update a User ------------------------------------------------
//
//	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//		logger.info("Updating User with id {}", id);
//
//		User currentUser = userService.findById(id);
//
//		if (currentUser == null) {
//			logger.error("Unable to update. User with id {} not found.", id);
//			return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
//					HttpStatus.NOT_FOUND);
//		}
//
//		currentUser.setName(user.getName());
//		currentUser.setAge(user.getAge());
//		currentUser.setSalary(user.getSalary());
//
//		userService.updateUser(currentUser);
//		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//	}
//
//	// ------------------- Delete a User-----------------------------------------
//
//	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
//		logger.info("Fetching & Deleting User with id {}", id);
//
//		User user = userService.findById(id);
//		if (user == null) {
//			logger.error("Unable to delete. User with id {} not found.", id);
//			return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
//					HttpStatus.NOT_FOUND);
//		}
//		userService.deleteUserById(id);
//		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	}
//
//	// ------------------- Delete All Users-----------------------------
//
//	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//	public ResponseEntity<User> deleteAllUsers() {
//		logger.info("Deleting All Users");
//
//		userService.deleteAllUsers();
//		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	}

	// -------------------Retrieve All Students---------------------------------------------

	@RequestMapping(value = "/student/", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listAllStudents() {
		List<Student> students = studentService.findAllStudents();
		if (students.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	// -------------------Create a Student-------------------------------------------

	@RequestMapping(value = "/student/", method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Student : {}", student);

		if (studentService.isStudentExist(student)) {
			logger.error("Unable to create. A Student with name {} already exist", student.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Student with name " +
					student.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		studentService.saveStudent(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/student/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Delete a Student-----------------------------------------

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudent(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Student with id {}", id);

		Student student = studentService.findById(id);
		if (student == null) {
			logger.error("Unable to delete. Student with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Student with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		studentService.deleteStudentById(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Update a Student ------------------------------------------------

	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		logger.info("Updating Student with id {}", id);

		Student currentStudent = studentService.findById(id);

		if (currentStudent == null) {
			logger.error("Unable to update. Student with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Student with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentStudent.setName(student.getName());
		currentStudent.setSurname(student.getSurname());
		currentStudent.setUniversity(student.getUniversity());
		currentStudent.setFaculty(student.getFaculty());
		currentStudent.setGroup(student.getGroup());
		currentStudent.setRoomNumber(student.getRoomNumber());

		studentService.updateStudent(currentStudent);
		return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
	}

	// -------------------Retrieve Single Student------------------------------------------

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getStudent(@PathVariable("id") long id) {
		logger.info("Fetching Student with id {}", id);
		Student student = studentService.findById(id);
		if (student == null) {
			logger.error("Student with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Student with id " + id
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}