package com.verizon.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:"
		,glue={"com.verizon.StepDefinitions"}
		)
 
public class TestRunner extends AbstractTestNGCucumberTests{
 
}

