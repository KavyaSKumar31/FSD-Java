package com.redneuron.myapp.service;

import java.util.ArrayList;
import java.util.List;

import com.redneuron.myapp.model.Todo;
import com.redneuron.myapp.model.User;

public class todoService {
	ArrayList<Todo> arrli = new ArrayList<Todo>(); 
	public void add(Todo todo) {
		
		arrli.add(todo);
		
		
		
		
		
	}
	public List<Todo> list() {
		return arrli;
	}
}
