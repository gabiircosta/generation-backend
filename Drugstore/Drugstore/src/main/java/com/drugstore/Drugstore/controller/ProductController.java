package com.drugstore.Drugstore.controller;

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

import com.drugstore.Drugstore.model.Category;
import com.drugstore.Drugstore.model.Product;
import com.drugstore.Drugstore.repository.ProductRepository;

@RestController
@RequestMapping ("/products")
@CrossOrigin ("*")
public class ProductController {

	@Autowired
	public ProductRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Product>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity <Product> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("name/{name}")
	public ResponseEntity<List<Product>> GetBySection (@PathVariable String name) {
		return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
	}
	@PostMapping
	public ResponseEntity<Product> post (@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
	}
	@PutMapping
	public ResponseEntity<Product> put (@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(product));
	}	
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}
