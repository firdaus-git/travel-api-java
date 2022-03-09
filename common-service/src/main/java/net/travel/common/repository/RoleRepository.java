package net.travel.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.travel.common.enums.Roles;
import net.travel.common.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(Roles name);
}

