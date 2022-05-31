package com.berserk.portfolio.controller;

import com.berserk.portfolio.entity.Persona;
import com.berserk.portfolio.entity.Skill;
import com.berserk.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<Persona> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<Persona> findById(@PathVariable("id") int integer) {
        return userService.findById(integer);
    }

    @PutMapping("/user/{id}")
    public Persona update(@RequestBody Persona persona , @PathVariable int id){
        Persona persona1 = userService.findById(id).get();
        persona1.setNombre(persona.getNombre());
        persona1.setApellido(persona.getNombre());
        persona1.setCorreo(persona.getNombre());
        persona1.setSobreMi(persona.getNombre());
        persona1.setUrlFoto(persona.getNombre());
        return userService.save(persona);
    }

}
