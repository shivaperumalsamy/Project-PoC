package com.sirius.security.securitydbexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirius.security.securitydbexample.model.Resources;

@Repository
public interface ResourcesRepository extends JpaRepository<Resources,Integer> {

	Resources findByRole(String role);


}
