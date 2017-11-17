package com.mustafa.test.Test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product, Long> {

	public List<Product> findAllByOrderByIdAsc();
	
}
