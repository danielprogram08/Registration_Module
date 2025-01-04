package com.registration_module.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.registration_module.demo.dto.AdmDTO;
import com.registration_module.demo.entity.AdmEntity;

public interface AdmRepository extends JpaRepository<AdmEntity, Long> {
    @Query(value = "SELECT a.name, a.password FROM administrators a WHERE a.name = :name AND a.password = password", nativeQuery = true)
    AdmDTO findByCredentials(String name, String password);
}