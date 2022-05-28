package com.berserk.portfolio.service;

import com.berserk.portfolio.entity.Educacion;
import com.berserk.portfolio.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    public List<Educacion> findAll() {
        return educacionRepository.findAll();
    }

    public Optional<Educacion> findById(Integer integer) {
        return educacionRepository.findById(integer);
    }

    public Educacion save(Educacion entity) {
        return educacionRepository.save(entity);
    }

    public boolean remove(int id) {
        if (educacionRepository.existsById(id)) {
            educacionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
