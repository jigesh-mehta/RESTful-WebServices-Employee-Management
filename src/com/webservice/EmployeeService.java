package com.webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/EmployeeService")
public class EmployeeService {

	EmployeeDao empDao = new EmployeeDao();
	private static final String SUCCESS_RESULT = "<result>Success!</result>";
	private static final String FAILURE_RESULT = "<result>Failure!</result>";

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
	
	@PUT
	@Path("/employee")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser(@FormParam("id") int id,
			@FormParam("name") String name,
			@FormParam("profession") String profession,
			@FormParam("salary") int salary,
			@Context HttpServletResponse servletResponse) throws IOException {
		Employee emp = new Employee(id, name, profession, salary);
		int result = empDao.addEmployee(emp);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}
}
