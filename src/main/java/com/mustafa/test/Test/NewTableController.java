package com.mustafa.test.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewTableController {
	
	@Autowired
	INewTableRepo repo;
	
	@RequestMapping(path = "/")
	public List<NewTable> getall() {
		return repo.findAll();
	}
	
	@RequestMapping(path = "/getid/{id}")
	public NewTable getById(@PathVariable Long id) {
		return repo.findOne(id);
	}
	
	@RequestMapping(path = "/getname/{name}")
	public List<NewTable> getByName(@PathVariable String name) {
		return repo.findByName(name);
	}
	
	@RequestMapping(path = "/save/{id}/{name}", method = RequestMethod.POST)
	public String save(@PathVariable Long id, @PathVariable String name) {
		try {
			NewTable entry = new NewTable();
			entry.setId(id);
			entry.setName(name);
			repo.save(entry);
			return "Saved Successful";
		} catch(Throwable e) {
			System.out.println("Save Failed" + e.getMessage());
			return "Save Failed";
		}
	}
	
}
