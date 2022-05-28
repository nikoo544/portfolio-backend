package com.berserk.portfolio.controller;

import com.berserk.portfolio.entity.Experiencia;
import com.berserk.portfolio.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/experiencia")
    public List<Experiencia> findAll() {
        return experienciaService.findAll();
    }

    @GetMapping("/experiencia/{id}")
    public Optional<Experiencia> findById(@PathVariable int id) {
        return experienciaService.findById(id);
    }

    @PostMapping("/experiencia")
    public Experiencia create(@RequestBody Experiencia experiencia) {
        return experienciaService.save(experiencia);
    }

    @DeleteMapping("/experiencia/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return experienciaService.remove(id);
    }

    @PutMapping("/experiencia/{id}")
    public Experiencia update(@RequestBody Experiencia experiencia,@PathVariable int id) {

        Experiencia experienciaActualizada = experienciaService.findById(id).get();
        experienciaActualizada.setNombre(experiencia.getNombre());
        experienciaActualizada.setDescripcion(experiencia.getDescripcion());
        experienciaActualizada.setFechaInicio(experiencia.getFechaInicio());
        experienciaActualizada.setFechaFin(experiencia.getFechaFin());

        return experienciaService.save(experienciaActualizada);
    }

}
