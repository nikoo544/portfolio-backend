package com.berserk.portfolio.service;

import com.berserk.portfolio.entity.Skill;
import com.berserk.portfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Optional<Skill> findById(Integer integer) {
        return skillRepository.findById(integer);
    }

    public boolean remove(int id) {
        if (skillRepository.existsById(id)) {
            skillRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

