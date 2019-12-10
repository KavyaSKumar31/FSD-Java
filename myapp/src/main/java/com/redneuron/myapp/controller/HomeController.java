package com.redneuron.myapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.redneuron.myapp.model.Todo;
import com.redneuron.myapp.model.User;
import com.redneuron.myapp.service.loginService;
import com.redneuron.myapp.service.todoService;







@Controller
public class HomeController {
loginService loginservice = new loginService();
todoService todoservice = new todoService();
	@RequestMapping(value="/")
	public String test(Model theModel){
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "login";
	}
	@RequestMapping(value="/loginProcess",method = RequestMethod.GET)
	public String getLoginForm(Model model) {
		/* model.addAttribute("user", new User()); */
		return "login";
	}
	
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response){
		boolean result= false;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		result = loginservice.login(userName,password);
		if(result) {
		return "home";
	}else {
		 
		return"login";
	}
}
	@RequestMapping(value="/addTodo")
	public String add(@ModelAttribute("todo") Todo todo,Model theModel){
		
		theModel.addAttribute("todo", todo);
		todoservice.add(todo);
		return "list-todos";
	}
	@RequestMapping(value="/listTodo")
public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Todo> theTodos = todoservice.list();
				
		// add the customers to the model
		theModel.addAttribute("todos", theTodos);
		
		return "list-todos";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Todo theTodo = new Todo();
		
		theModel.addAttribute("todo", theTodo);
		
		return "todo-form";
	}
	@RequestMapping(value="/home")
	public String home(){
		
		return "home";
	}
}
