package com.wayfinder.app.service;

import java.util.List;

import com.wayfinder.app.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	void insertEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void executeUpdateEmployee(Employee emp);

	void deleteEmployee(Employee emp);
	
}
