package com.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,glue = {"com.stepdefinitions"},features = {"C:\\Users\\35024\\git\\repository\\OpenWeather\\src\\main\\java\\features"},tags = {"@FiveDayWeather"} )
public class RunnerTest {
		
	

}
