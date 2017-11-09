package com.mustafa.test.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewTableController {
	
	@Autowired
	INewTableRepo repo;
	
	@RequestMapping(path = "/")
	public List<NewTable> getall() {
		return repo.findAll();
	}
	
}
