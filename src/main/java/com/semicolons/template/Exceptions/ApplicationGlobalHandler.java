package com.semicolons.template.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationGlobalHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> ExceptionHandlerMethod(ResourceNotFoundException obj){
		
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("message", obj.getMessage());
		map.put("success", false);
		map.put("status",HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,Object>> ExceptionHandlerMethodAll(Exception obj){
		
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("message", obj.getMessage());
		map.put("success", false);
		map.put("status",HttpStatus.BAD_REQUEST);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
}
