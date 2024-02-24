package com.semicolons.template.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name="Templates")
public class Template {
	
	@Id
	@Column(unique=true)
	private String templateId;
	
	@NotNull(message="reportId can't be Null")
	@Valid
	private String reportId;
	
	@Column(columnDefinition = "TEXT")
	private String templateContent;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public Template() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Template(String templateId, String reportId, String templateContent) {
		super();
		this.templateId = templateId;
		this.reportId = reportId;
		this.templateContent = templateContent;
	}
	
	
	
}
