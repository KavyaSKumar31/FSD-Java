package com.mycompany.hibernate_crud_demo.dao;

import java.util.List;

import com.mycompany.hibernate_crud_demo.shared.SharedEmployee;

public interface EmployeeDAO {

	public void createEmployee(SharedEmployee sEmployee);

	public List<SharedEmployee> getAllEmployee();

	public SharedEmployee findById(int id);
	
	public void findByCustomId(String customId);
	
	public void deleteEmployee(int id);
	
	public void updateEmployee(int id);

	public void deleteCustomId(String id);
	public void updateCustomId(String customId);

}
