package org.efeitoeco.blogPessoal.repository;

import java.util.Optional;

import org.efeitoeco.blogPessoal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByUser(String user);
}
