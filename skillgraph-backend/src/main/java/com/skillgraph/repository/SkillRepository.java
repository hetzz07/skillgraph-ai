package com.skillgraph.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillgraph.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    boolean existsBySkillName(String skillName);

}