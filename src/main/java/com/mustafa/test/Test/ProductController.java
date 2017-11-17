package com.mustafa.test.Test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	@Autowired
	IProductRepo repo;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String productlist(Map<String, Object> model) {
		model.put("products", getall());
		return "productlist";
	}
	
	@RequestMapping(path = "/product")
	public String product(String s) {
		return "product";
	}
	
	@RequestMapping(path = "/save/{name}/{desc}")
	public void saveProduct(@PathVariable String name, @PathVariable String desc) {
		Product p = new Product();
		p.setName(name);
		p.setDesc(desc);
		repo.save(p);
	}

	public List<Product> getall() {
		return repo.findAllByOrderByIdAsc();
	}
	
/*
	@RequestMapping(path = "/getall")
	public List<Product> getall() {
		return repo.findAll();
	}
	
	@RequestMapping(path = "/getid/{id}")
	public Product getById(@PathVariable Long id) {
		return repo.findOne(id);
	}
	
	@RequestMapping(path = "/getname/{name}")
	public List<Product> getByName(@PathVariable String name) {
		return repo.findByName(name);
	}
	
	@RequestMapping(path = "/save/{id}/{name}", method = RequestMethod.POST)
	public String save(@PathVariable Long id, @PathVariable String name) {
		try {
			Product entry = new Product();
			entry.setId(id);
			entry.setName(name);
			repo.save(entry);
			return "Saved Successful";
		} catch(Throwable e) {
			System.out.println("Save Failed" + e.getMessage());
			return "Save Failed";
		}
	}
*/
}
