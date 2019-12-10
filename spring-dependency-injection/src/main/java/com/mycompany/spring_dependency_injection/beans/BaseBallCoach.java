package com.mycompany.spring_dependency_injection.beans;

import lombok.Setter;

@Setter
public class BaseBallCoach implements Coach {

	private Fortune fortune;

	@Override
	public String getDailyWorkout() {

		return "practice back volley today";
	}

	@Override
	public String getDailyFortune() {

		return fortune.getFortune().toString();
	}

}
