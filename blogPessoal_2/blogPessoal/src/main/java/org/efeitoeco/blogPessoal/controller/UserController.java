package org.efeitoeco.blogPessoal.controller;

import java.util.Optional;

import org.efeitoeco.blogPessoal.model.User;
import org.efeitoeco.blogPessoal.model.UserLogin;
import org.efeitoeco.blogPessoal.repository.UserRepository;
import org.efeitoeco.blogPessoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/users")
@CrossOrigin ("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping ("/login")
	public ResponseEntity<UserLogin> Authentication (@RequestBody Optional <UserLogin> user){
		return userService.Logar(user).map(resp -> ResponseEntity.ok (resp))
				.orElse (ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	@PostMapping ("/insert")
	public ResponseEntity <User> Post (@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.insertUser(user));
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<User> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	
}
