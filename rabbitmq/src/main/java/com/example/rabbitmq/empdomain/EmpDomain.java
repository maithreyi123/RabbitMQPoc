package com.example.rabbitmq.empdomain;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = EmpDomain.class)
public class EmpDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String empId;

	private String empName;

	public EmpDomain() {
		super();

	}

	public EmpDomain(String empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "EmpDomain [empId=" + empId + ", empName=" + empName + "]";
	}

}
