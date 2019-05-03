package com.example.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.empdomain.EmpDomain;
import com.example.rabbitmq.service.RabbitMqSender;

@RestController
@RequestMapping(value="api/v1")
public class RabbitMqController {
	
	@Autowired
	RabbitMqSender rabbitMqSender;
	
	@GetMapping(value="/employee")
	public String Save(@RequestParam(value ="empId", required=false) String empId, @RequestParam(value="empName", required=false) String empName)
	{
		EmpDomain emp = new EmpDomain();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		rabbitMqSender.send(emp);
		return "Message is successfully sent to RabbitMq";
		
	}
	
	
	
	
	

}
