package com.semicolons.template.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.semicolons.template.Entities.Template;
import jakarta.transaction.Transactional;

@Repository
public interface TemplateRepository extends JpaRepository<Template,String>{

	@Transactional
	Long deleteByReportId(String reportId);

	List<Template> findByReportId(String reportId);

}
