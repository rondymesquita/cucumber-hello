package br.com.example;


import gherkin.formatter.JSONPrettyFormatter;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorStepdefs {
	
	Calculator calculator;
	
	@Before
	public void before(){
//		System.out.println("=== Starting...");
	}
	
	@After
	public void after() throws Exception{
//		System.out.println("=== Finished");
		
		List<String> jsonReportFiles = new ArrayList<String>();
    	jsonReportFiles.add(RunCukesTest.REPORT_FOLDER+"/report.json");
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles, new File(RunCukesTest.REPORT_FOLDER),"", Calendar.getInstance().getTime().toString(), "cucumber-jvm", false, false, false, false, false, "", false);
    	reportBuilder.generateReports();
	}
	
	@Given("^I have a calculator$")
	public void iHaveACalculator() throws Throwable{
		calculator = new Calculator();	
	}
	
	@When("^I add (\\d+) and (\\d+)$")
	public void iAdd(int value1, int value2) throws Throwable{
		calculator.add(value1, value2);
	}
	
	@Then("the result should be (\\d+)$")
	public void theResultShouldBe(int result) throws Throwable{
		Assert.assertEquals(calculator.getResult(), result);
	}
}
