package com.raja.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raja.application.dao.EmployeeReprository;
import com.raja.application.model.Employee;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeReprository employeeReprository;

	@GetMapping("/getEmployeeDetails")
	public ResponseEntity getEmployeeDetails(HttpServletRequest request) {
		logger.info("inside getEmployeeDetails............");
		List<Employee> list = new ArrayList<Employee>();
		if (list == null) {
			// return ResponseEntity.badRequest()
		} else {
			List<Employee> listData = (List<Employee>) employeeReprository.findAll();
			return ResponseEntity.ok().body(listData);
		}

		return ResponseEntity.badRequest().body("");
	}

}
