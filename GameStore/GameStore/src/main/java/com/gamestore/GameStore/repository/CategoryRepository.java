package com.gamestore.GameStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamestore.GameStore.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
	public List <Category> findAllByTypeContainingIgnoreCase (String type);	
}
