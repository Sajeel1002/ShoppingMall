package com.cg.sm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private EmployeeService service;
	//Retrieval
		@GetMapping("/employees")
		public List<employee>list(){
			return  service.listAll();
		}	
		
		//Retrieve By id
		@GetMapping("/employees/{id}")
		public ResponseEntity <employee> get(@PathVariable Integer id){
			try {
				employee Employee= service.get(id);
				return new ResponseEntity<employee>(Employee,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<employee>(HttpStatus.NOT_FOUND);

			}
		}
		//create
				@PostMapping("/employees")
				public void add(@RequestBody employee Employee) {
					service.save(Employee);
				}
				//Update
				@PutMapping("/employees/{id}")
				public ResponseEntity<?>update(@RequestBody employee Employee, @PathVariable Integer id){
					try {
						@SuppressWarnings("unused")
						employee existadmin=service.get(id);
						service.save(Employee);
						return new ResponseEntity <> (HttpStatus.OK);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
					}
				@DeleteMapping("/employees/{id}")
					public void delete(@PathVariable Integer id) {
				service.delete(id);
				}
				
		}
