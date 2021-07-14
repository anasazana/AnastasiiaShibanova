package ru.training.at.hw5.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "ru.training.at.hw5")
public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
