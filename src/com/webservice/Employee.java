package com.webservice;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String profession;
	private int salary;
	
	public Employee(){
		
	}
	
	public Employee(int id, String name, String profession, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.profession = profession;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProfession() {
		return profession;
	}
	@XmlElement
	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getSalary() {
		return salary;
	}
	@XmlElement
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof Employee)) {
			return false;
		} else {
			Employee emp = (Employee) object;
			if (id == emp.getId() && name.equals(emp.getName())
					&& profession.equals(emp.getProfession()) && salary == emp.getSalary()) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		System.out.println("in toString");
		String s = "ID : " + this.id + " Name : " + this.name + " Profession : " + this.profession + " Salary : " + this.salary + "\n";
		return s;
	}
}
