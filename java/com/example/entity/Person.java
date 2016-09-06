package com.example.entity;

import java.util.List;

import lombok.Data;

@Data
public class Person {

	private String firstName;
	private String lastName;
	private String middle;
	private int	   height; 
	private int    age;
	private List<String> interests;
}
