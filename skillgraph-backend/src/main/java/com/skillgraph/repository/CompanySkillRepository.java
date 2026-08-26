package com.skillgraph.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillgraph.model.CompanySkill;

@Repository
public interface CompanySkillRepository extends JpaRepository<CompanySkill, Long> {

    List<CompanySkill> findByCompanyName(String companyName);

}