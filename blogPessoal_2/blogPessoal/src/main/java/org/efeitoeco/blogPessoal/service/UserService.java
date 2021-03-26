package org.efeitoeco.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.efeitoeco.blogPessoal.model.User;
import org.efeitoeco.blogPessoal.model.UserLogin;
import org.efeitoeco.blogPessoal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User insertUser (User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String passwordEncoder = encoder.encode(user.getPassword());
		user.setPassword(passwordEncoder);
		
		return repository.save(user);
		}
	
	public Optional<UserLogin> Logar (Optional <UserLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder ();
		Optional <User> usuario = repository.findByUser(user.get ().getUser());
		
		if (usuario.isPresent()){
			if(encoder.matches(user.get().getPassword(), usuario.get().getPassword())) {
				String auth = user.get().getUser() +":"+user.get().getPassword();
				byte [] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic" + " " + new String (encodeAuth);
				
				user.get().setToken(authHeader);
				user.get().setId(usuario.get().getId());
				user.get().setName(usuario.get().getName());
				user.get().setPassword(usuario.get().getPassword());
				user.get().setPhoto(usuario.get().getPhoto());
				user.get().setType(usuario.get().getType());
				
				return user;
			}
		}
		return null;
	}

}
