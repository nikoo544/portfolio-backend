package com.berserk.portfolio.controller;

import com.berserk.portfolio.entity.Educacion;
import com.berserk.portfolio.service.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/educacion")
    public List<Educacion> findAll() {
        return educacionService.findAll();
    }

    @GetMapping("/educacion/{id}")
    public Optional<Educacion> findById(@PathVariable int id) {
        return educacionService.findById(id);
    }

    @PostMapping("/educacion")
    public Educacion create(@RequestBody Educacion educacion) {
        return educacionService.save(educacion);
    }

    @DeleteMapping("/educacion/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return educacionService.remove(id);
    }

    @PutMapping("/educacion/{id}")
    public Educacion update(@RequestBody Educacion educacion,@PathVariable int id) {

        Educacion educacionActualizada = educacionService.findById(id).get();
        educacionActualizada.setInstitucion(educacion.getInstitucion());
        educacionActualizada.setTitulo(educacion.getTitulo());
        educacionActualizada.setFechaInicio(educacion.getFechaInicio());
        educacionActualizada.setFechaFin(educacion.getFechaFin());

        return educacionService.save(educacionActualizada);
    }

}
