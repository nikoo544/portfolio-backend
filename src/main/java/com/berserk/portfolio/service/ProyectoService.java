package com.berserk.portfolio.service;

import com.berserk.portfolio.entity.Proyecto;
import com.berserk.portfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> findById(Integer integer) {
        return proyectoRepository.findById(integer);
    }

    public Proyecto save(Proyecto entity) {
        return proyectoRepository.save(entity);
    }

    public boolean remove(int id) {
        if (proyectoRepository.existsById(id)) {
            proyectoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}