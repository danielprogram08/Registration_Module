package com.registration_module.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registration_module.demo.dto.AdmDTO;
import com.registration_module.demo.repository.AdmRepository;

@Service
public class AdmService {

    @Autowired
    private AdmRepository repository;

    @Transactional(readOnly = true)
    public Optional<AdmDTO> SearchByCredentials (String name, String password) { //Optional in case of the value be like empty;
        Optional<AdmDTO> result = Optional.ofNullable(repository.findByCredentials(name, password));
        if (!result.isPresent()) {
            System.out.println("\n Administrador não encontrado!");
        }
        return result;
    }
}