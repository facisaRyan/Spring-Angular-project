package br.com.space.store.tectall.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.space.store.tectall.enums.RoleName;
import br.com.space.store.tectall.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, UUID>{

	RoleModel findByRolename(RoleName roleClient);

}
