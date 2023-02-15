package com.cg.sm;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private Repository repository;
	public List<employee> listAll(){
		return repository.findAll();
}
	public employee get(Integer id) {
		return  repository.findById(id).get();
	}
	
	public void save(employee Employee) {
		repository.save(Employee);
		
	}
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	}

