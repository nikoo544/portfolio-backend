package com.berserk.portfolio.service;

import com.berserk.portfolio.entity.Persona;
import com.berserk.portfolio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Nico - THE WIZARD
 */

@Service
@Transactional
public class UserService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public Optional<Persona> findById(Integer integer) {
        return personaRepository.findById(integer);
    }
}
