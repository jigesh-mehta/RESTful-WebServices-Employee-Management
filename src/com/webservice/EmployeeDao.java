package com.webservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeDao {
	String employeeFile = "EmployeeData.dat";
	
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			File empFile = new File(employeeFile);
			if(!empFile.exists()) {
				Employee emp  = new Employee(1, "Jigesh Mehta", "Software Developer", 100000);
				empList = new ArrayList<Employee>();
				empList.add(emp);
				saveEmpList(empList, employeeFile);
			} else {
				FileInputStream fis = new FileInputStream(empFile);
				ObjectInputStream ois = new ObjectInputStream(fis);
				empList = (List<Employee>)ois.readObject();
				fis.close();
				ois.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*Iterator<Employee> itr = empList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		return empList;
	}
	
	public Employee getEmployee(int id) {
		List<Employee> empList = getAllEmployees();
		Employee emp = null;
		
		Iterator<Employee> itr = empList.iterator();
		while(itr.hasNext()) {
			Employee curr = itr.next();
			if(curr.getId() == id) {
				emp = curr;
				break;
			}
		}
		
		return emp;
	}
	
	public int addEmployee(Employee emp) {
		List<Employee> empList = getAllEmployees();
		boolean employeeExists = false;
		for (Employee e : empList) {
			if (e.getId() == emp.getId()) {
				employeeExists = true;
				break;
			}
		}
		if (!employeeExists) {
			empList.add(emp);
			saveEmpList(empList, employeeFile);
			return 1;
		}
		return 0;
	}
	
	private static void saveEmpList(List<Employee> empList, String employeeFile) {
		try {
			File f = new File(employeeFile);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(empList);
			fos.close();
			oos.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
