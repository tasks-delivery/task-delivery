package com.tloureiro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tloureiro.entity.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Integer>{

	public List<Organization> findByNameContainingIgnoreCase(String name);
}
