package br.com.space.store.tectall.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.space.store.tectall.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{

	Optional<UserModel> findByEmail(String email);

}
