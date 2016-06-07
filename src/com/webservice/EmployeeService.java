package com.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/EmployeeService")
public class EmployeeService {

	EmployeeDao empDao = new EmployeeDao();

	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getEmployees() {
		return empDao.getAllEmployees();
	}
	
	@GET
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(@PathParam("id") int id) {
		return empDao.getEmployee(id);
	}
}
