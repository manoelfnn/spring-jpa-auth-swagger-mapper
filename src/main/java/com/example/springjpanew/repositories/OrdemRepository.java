package com.example.springjpanew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpanew.entities.Ordem;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {

	
}
