package com.semicolons.template.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semicolons.template.Entities.Template;
import com.semicolons.template.Exceptions.ResourceNotFoundException;
import com.semicolons.template.Repositories.TemplateRepository;

@Service
public class TemplateService {
	
	@Autowired
	private TemplateRepository templateRepository;
	

    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    public Template getTemplateById(String templateId) {
        return templateRepository.findById(templateId).orElseThrow(()->new ResourceNotFoundException());
    }
    
    public List<Template> getTemplateByReportId(String reportId) {
    	try {
        return templateRepository.findByReportId(reportId);
    	}
    	catch(Exception ex)
    	{
    		throw new ResourceNotFoundException();
    	}
    }

    public Template createTemplate(Template template) {
        return templateRepository.save(template);
    }

    public void deleteTemplateById(String templateId) {
    	templateRepository.findById(templateId).orElseThrow(()->new ResourceNotFoundException());
        templateRepository.deleteById(templateId);
    }
    
    public long deleteTemplateByReportId(String reportId) {
    	
        return templateRepository.deleteByReportId(reportId);
    }

    public void deleteAllTemplates()
    {
    	templateRepository.deleteAll();
    }

}


