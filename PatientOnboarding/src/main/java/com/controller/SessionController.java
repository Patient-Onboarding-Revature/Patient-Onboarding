package com.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.PatientDao;
import com.dao.UserRoleDao;
import com.model.Patient;
import com.model.UserRole;

@RequestMapping
@CrossOrigin(origins = "*")
@Controller
public class SessionController {
	
	private PatientDao patientDao;
	private UserRoleDao userRoleDao;

	@Autowired
	public SessionController(PatientDao patientDao, UserRoleDao userRoleDao) {
		super();
		this.patientDao = patientDao;
		this.userRoleDao = userRoleDao;
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
		String firstname = ang.get("firstname");
		String lastname = ang.get("lastname");
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
