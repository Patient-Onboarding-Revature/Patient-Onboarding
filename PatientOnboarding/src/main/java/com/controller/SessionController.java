package com.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.AdminDao;
import com.dao.DoctorDao;
import com.dao.PatientDao;
import com.dao.UserRoleDao;
import com.model.Admin;
import com.model.Doctor;
import com.model.Patient;
import com.model.UserRole;

@RequestMapping
@CrossOrigin(origins = "http://patient-onboarding-test.storage.googleapis.com")
@Controller
public class SessionController {
	
	private PatientDao patientDao;
	private UserRoleDao userRoleDao;
	private AdminDao adminDao;
	private DoctorDao doctorDao;

	@Autowired
	public SessionController(PatientDao patientDao, UserRoleDao userRoleDao,
			AdminDao adminDao, DoctorDao doctorDao) {
		super();
		this.patientDao = patientDao;
		this.userRoleDao = userRoleDao;
		this.adminDao = adminDao;
		this.doctorDao = doctorDao;
	}
	
	public SessionController() {}

//	@GetMapping(value="/insertuser.app")
//	public String login(HttpServletRequest req) {
//		HttpSession session = req.getSession();
//		System.out.println("in the login method");
//		
//		//session.
//		
//		//System.out.println("\n\n\n");
//		return "nextpage.html";
//	}
	
//	@RequestMapping(value="/api/insertuser.app")
//	void getTest(HttpServletRequest req) {
//		System.out.println("in get test");
//	}
	
//	@SuppressWarnings("unchecked")
//	@GetMapping(value="/api/insertuser.app", consumes = MediaType.ALL_VALUE)
//	public @ResponseBody Patient getTest(@RequestBody Object stuff) {
//		System.out.println("in get test");
//		
//		ArrayList<String> ang = (ArrayList<String>) stuff;
//		String firstname = ang.get(0);
//		String lastname = ang.get(1);
//		String username = ang.get(2);
//		String password = ang.get(3);
//		
//		System.out.println(firstname + " " + lastname+" "+username+" "+password);
//		
//		//Admin admin = new Admin(firstname,lastname,username,password);
//		
//		return freqDao.select(1);
//	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/insertuser.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Patient postTest(@RequestBody Object stuff) {
		System.out.println("in post test");
		
		LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
		String firstname = ang.get("firstName");
		String lastname = ang.get("lastName");
		String username = ang.get("username");
		String password = ang.get("password");
		
		System.out.println(firstname + " " + lastname+" "+username+" "+password);
		
		Patient p = new Patient(firstname,lastname,username,password);
		UserRole role = userRoleDao.select(1);
		p.setRole(role);
		p.setMiddleInit('s');
		p.setZip(0);
		p.setNumber(0);
		System.out.println(p);
		patientDao.insert(p);
		
		Patient patient = patientDao.selectByUsername(username);
		System.out.println(patient);
		
		return patient;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/loginuser.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Patient loginPatient(@RequestBody Object stuff) {
		System.out.println("patient login");
		
		LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
		String username = ang.get("username");
		String password = ang.get("password");
		
		System.out.println(username+" "+password);
		
		Patient patient = patientDao.selectByUsername(username);
		System.out.println(patient);
		
		return patient;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/loginadmin.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Admin loginAdmin(@RequestBody Object stuff) {
		System.out.println("login admin");
		
		LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
		String username = ang.get("username");
		String password = ang.get("password");
		
		System.out.println(username+" "+password);
		
		Admin admin = adminDao.selectByUsername(username);
		System.out.println(admin);
		
		return admin;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/logindoctor.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Doctor loginDoctor(@RequestBody Object stuff) {
		System.out.println("login doctor");
		
		LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
		String username = ang.get("username");
		String password = ang.get("password");
		
		System.out.println(username+" "+password);
		
		Doctor doctor = doctorDao.selectByUsername(username);
		System.out.println(doctor);
		
		return doctor;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/updateuser.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Patient update(@RequestBody Object stuff) {
		System.out.println("updating patient");
		
		LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
		String firstName = ang.get("firstName");
		String lastName = ang.get("lastName");
		Character middleInit = ang.get("middleInit").charAt(0);
		String username = ang.get("username");
		String password = ang.get("password");
		String address = ang.get("address");
		String state = ang.get("state");
		Integer zip = Integer.parseInt(ang.get("zip"));
		Long number = Long.parseLong(ang.get("number"));
		String email = ang.get("email");
		
		Patient patient = patientDao.selectByUsername(username);
		System.out.println(patient);
		
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setMiddleInit(middleInit);
		patient.setUsername(username);
		patient.setPassword(password);
		patient.setAddress(address);
		patient.setState(state);
		patient.setZip(zip);
		patient.setNumber(number);
		patient.setEmail(email);
		System.out.println(patient);
		
		patientDao.update(patient);
		
		Patient p2 = patientDao.selectByUsername(username);
		System.out.println(p2);
		
		return p2;
	}
	
	@GetMapping(value="/api/selectuser.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody List<Patient> allPatients() {
		System.out.println("in allPatients");
		
		List<Patient> patients = patientDao.selectAll();
		System.out.println(patients);
		
		return patients;
	}
	
//	@RequestMapping(value="/api/insertuser.app")
//    public @ResponseBody String test(HttpServletRequest req) {
//        System.out.println("in post test");
//        return freqDao.selectAll().toString();
//    }
	
//	@ResponseBody
//	public Admin handle(@RequestParam(value = "user") String user,HttpServletRequest request){
//		return new Admin();
//	}

	
}
