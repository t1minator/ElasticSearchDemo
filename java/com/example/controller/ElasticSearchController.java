package com.example.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Person;
import com.example.service.RestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ElasticSearchController {
	@Autowired
	private RestService restService;
	ObjectMapper objectMapper = new ObjectMapper();
	private String jsonCmd = "";

	private String  ESURL = "http://localhost:9200/person/log/";
	@RequestMapping("/logPerson")
	public String  logPerson(Person person) throws JsonProcessingException {
		
		
		UUID id = UUID.randomUUID();
		jsonCmd = objectMapper.writeValueAsString(person);
		
		HttpEntity<String> entity = new HttpEntity<>(jsonCmd,restService.getHeader(id));
		RestTemplate template = restService.getRestTemplate();
		ResponseEntity<String> list = template.exchange(ESURL+id.toString(),HttpMethod.POST,entity, String.class);
		
		return jsonCmd;
	}

	@RequestMapping("findPerson")
	public ResponseEntity<String> findPerson(String id) throws JsonProcessingException{
		
		RestTemplate template = restService.getRestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(jsonCmd,restService.getHeader(UUID.randomUUID()));
		ResponseEntity<String> re = template.exchange(ESURL+id,HttpMethod.GET,entity,String.class);
		
		return re;		
	}
}
