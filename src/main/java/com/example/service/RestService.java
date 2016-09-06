package com.example.service;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Service
@Data
public class RestService {

	@Value("{example.servername}")
	String serverName;
	
	private RestTemplate restTemplate;
	
	public RestTemplate getRestTemplate(){
		
		if (restTemplate == null){
			restTemplate = new RestTemplate();
			restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
				protected boolean hasError(HttpStatus statusCode){
					return false;
				}
			});
		}
		return restTemplate;
	}
	
	public HttpHeaders getHeader(UUID ref){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("ref-id", ref.toString());
		
		return null;		
	}

	
	
}
