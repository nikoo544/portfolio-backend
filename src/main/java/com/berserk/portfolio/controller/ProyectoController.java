package com.berserk.portfolio.controller;

import com.berserk.portfolio.entity.Proyecto;
import com.berserk.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/proyecto")
    public List<Proyecto> findAll() {
        return proyectoService.findAll();
    }

    @GetMapping("/proyecto/{id}")
    public Optional<Proyecto> findById(@PathVariable int id) {
        return proyectoService.findById(id);
    }

    @PostMapping("/proyecto")
    public Proyecto create(@RequestBody Proyecto proyecto) {
        return proyectoService.save(proyecto);
    }

    @DeleteMapping("/proyecto/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return proyectoService.remove(id);
    }

    @PutMapping("/proyecto/{id}")
    public Proyecto update(@RequestBody Proyecto proyecto,@PathVariable int id) {

        Proyecto proyectoActualizado = proyectoService.findById(id).get();
        proyectoActualizado.setNombre(proyecto.getNombre());
        proyectoActualizado.setDescripcion(proyecto.getDescripcion());
        proyectoActualizado.setUrlFoto(proyecto.getUrlFoto());

        return proyectoService.save(proyectoActualizado);
    }

}
