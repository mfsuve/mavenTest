package com.mustafa.test.Test;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepo extends PagingAndSortingRepository<Product, Long> {

	public List<Product> findAllByOrderByIdAsc();
	
}
