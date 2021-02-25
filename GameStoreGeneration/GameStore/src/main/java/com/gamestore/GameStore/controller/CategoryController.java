package com.gamestore.GameStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamestore.GameStore.model.Category;
import com.gamestore.GameStore.repository.CategoryRepository;

@RestController
@RequestMapping ("/category")
@CrossOrigin  ("*")
public class CategoryController {
	
	@Autowired
	public CategoryRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Category>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping ("/{id}")
	public ResponseEntity <Category> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("type/{type}")
	public ResponseEntity<List<Category>> GetBySection (@PathVariable String type) {
		return ResponseEntity.ok(repository.findAllByTypeContainingIgnoreCase(type));
	}
	@PostMapping
	public ResponseEntity<Category> post (@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(category));
	}
	@PutMapping
	public ResponseEntity<Category> put (@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(category));
	}	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

}
