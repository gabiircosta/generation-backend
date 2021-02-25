package com.drugstore.Drugstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drugstore.Drugstore.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
//Não esqueça de colocar o long com L --> Formato primitivo
{
	public List <Category> findAllBySectionsContainingIgnoreCase (String sections);
}