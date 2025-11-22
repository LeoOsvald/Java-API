package br.edu.atitus.api_example.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.atitus.api_example.entities.UsuarioEntity;

public interface UserRepository extends JpaRepository<UsuarioEntity, UUID>{
	
	//select * from tb_user where email = {}
	boolean existsByEmail(String email);
	
	//select * from tb_user where email = {} and name = {}
	boolean existsByEmailAndName(String email, String name);
	
	Optional<UsuarioEntity> findByEmail(String email);

}
