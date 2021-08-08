package com.wayfinder.app.dao;

import java.util.List;

import com.wayfinder.app.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();

	void insertEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void executeUpdateEmployee(Employee emp);

	public void deleteEmployee(Employee emp);
}
