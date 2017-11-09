package com.mustafa.test.Test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface INewTableRepo extends JpaRepository<NewTable, Long> {

	public List<NewTable> findByName(String name);
	
}
