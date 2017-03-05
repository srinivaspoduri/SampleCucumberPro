package com.verizon.StepDefinitions;

import cucumber.api.java.en.Then;

public class StepDefinitions2 {

	
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
		StepDefinitions1.driver.quit();
		
	}
}
