package com.skillgraph.config;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.skillgraph.model.CompanySkill;
import com.skillgraph.repository.CompanySkillRepository;

@Configuration
public class DataInitializer {
  @Bean
  CommandLineRunner seedCompanySkills(CompanySkillRepository repository) {
    return args -> {
      if (repository.count() > 0) return;
      List<CompanySkill> data = List.of(
        new CompanySkill("Capgemini", "Java"), new CompanySkill("Capgemini", "Spring Boot"), new CompanySkill("Capgemini", "SQL"), new CompanySkill("Capgemini", "Git"),
        new CompanySkill("Infosys", "Java"), new CompanySkill("Infosys", "Angular"), new CompanySkill("Infosys", "SQL"), new CompanySkill("Infosys", "HTML"), new CompanySkill("Infosys", "CSS"),
        new CompanySkill("TCS", "Java"), new CompanySkill("TCS", "Spring Boot"), new CompanySkill("TCS", "MySQL"), new CompanySkill("TCS", "Git"),
        new CompanySkill("Accenture", "Java"), new CompanySkill("Accenture", "Spring Boot"), new CompanySkill("Accenture", "Angular"), new CompanySkill("Accenture", "Docker"), new CompanySkill("Accenture", "AWS"),
        new CompanySkill("Wipro", "Java"), new CompanySkill("Wipro", "SQL"), new CompanySkill("Wipro", "Git"), new CompanySkill("Wipro", "REST API"),
        new CompanySkill("Cognizant", "Java"), new CompanySkill("Cognizant", "Spring Boot"), new CompanySkill("Cognizant", "SQL"), new CompanySkill("Cognizant", "Angular")
      );
      repository.saveAll(data);
    };
  }
}
