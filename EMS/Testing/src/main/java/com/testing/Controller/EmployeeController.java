package com.testing.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testing.Entity.EmployeeEntity;
import com.testing.Exception.ResourceNotFoundException;
import com.testing.Repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	public EmployeeRepository employeerepo;
	
	//to get all employees
	@GetMapping("/employees")
	public List<EmployeeEntity> getAll() {
		return employeerepo.findAll();
	}
	
	//to create employee rest api
	@PostMapping("/employees")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
		return employeerepo.save(employee);
	}
	
	//get employee by id REST api
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) {
		EmployeeEntity employee= employeerepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		return ResponseEntity.ok(employee);
	}
	
	//put mapping(update) REST api
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id,@RequestBody EmployeeEntity employeeDetails){
		EmployeeEntity employee= employeerepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		EmployeeEntity updatedEmployee = employeerepo.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	//delete employee REST api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		
		EmployeeEntity employee= employeerepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		employeerepo.delete(employee);
		Map<String,Boolean>response=new HashMap();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
