package com.berserk.portfolio.controller;

import com.berserk.portfolio.entity.Skill;
import com.berserk.portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/skill")
    public List<Skill> findAll() {
        return skillService.findAll();
    }

    @GetMapping("/skill/{id}")
    public Optional<Skill> findById(@PathVariable int id) {
        return skillService.findById(id);
    }

    @PostMapping("/skill")
    public Skill create(@RequestBody Skill skill) {
        return skillService.save(skill);
    }

    @DeleteMapping("/skill/{id}")
    public boolean remove(@PathVariable int id) {
        return skillService.remove(id);
    }

    @PutMapping("/skill/{id}")
    public Skill update(@RequestBody Skill skill , @PathVariable int id){
        Skill skillActualizado = skillService.findById(id).get();
        skillActualizado.setNombre(skill.getNombre());
        skillActualizado.setPorcentaje(skill.getPorcentaje());
        return skillService.save(skillActualizado);
    }
}

