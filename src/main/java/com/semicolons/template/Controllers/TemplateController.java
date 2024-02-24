package com.semicolons.template.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.semicolons.template.Entities.Template;
import com.semicolons.template.Services.TemplateService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/template")
@Validated
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
    @PostMapping(value = "/")
    public ResponseEntity<Template> createTemplate(@RequestBody @Valid Template template ) {
    	String templateId = UUID.randomUUID().toString();
    	Template templateNew=new Template(templateId,template.getReportId(),template.getTemplateContent());
        return ResponseEntity.ok(templateService.createTemplate(templateNew));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Template>> getAllTemplates() {
    		return ResponseEntity.ok(templateService.getAllTemplates());
    }
    
    @GetMapping("/{templateId}")
    public ResponseEntity<Template> getTemplate(@PathVariable("templateId") String templateId) {
    		return ResponseEntity.ok(templateService.getTemplateById(templateId));
    }
    
    @GetMapping("/report/{reportId}")
    public ResponseEntity<List<Template>> getTemplatesByReportId(@PathVariable("reportId") String reportId) {
    		return ResponseEntity.ok(templateService.getTemplateByReportId(reportId));
    }


	 @DeleteMapping("/")
	 public ResponseEntity<String> deleteUsers() {    
		 templateService.deleteAllTemplates();
		 return ResponseEntity.ok("Successfully Deleted!");
	 }
	
	 @DeleteMapping("/{templateId}")
	 public ResponseEntity<String> deleteTemplateById(@PathVariable("templateId") String templateId) {
		 templateService.deleteTemplateById(templateId);
	     return ResponseEntity.ok("Successfully Deleted!");
	 }
	 
	 @DeleteMapping("/report/{reportId}")
	 public ResponseEntity<String> deleteTemplateByReportId(@PathVariable("reportId") String reportId) {
		 templateService.deleteTemplateByReportId(reportId);
	     return ResponseEntity.ok("Successfully Deleted!");
	 }
}
