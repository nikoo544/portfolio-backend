package com.berserk.portfolio.service;

import com.berserk.portfolio.entity.Experiencia;
import com.berserk.portfolio.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaService {


    @Autowired
    ExperienciaRepository experienciaRepository;

    public List<Experiencia> findAll() {
        return experienciaRepository.findAll();
    }

    public Optional<Experiencia> findById(Integer integer) {
        return experienciaRepository.findById(integer);
    }

    public Experiencia save(Experiencia entity) {
        return experienciaRepository.save(entity);
    }

    public boolean remove(int id) {
        if (experienciaRepository.existsById(id)) {
            experienciaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}