package org.example.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\main\\resources\\features",
        glue = "org.example.stepdefs",
        tags = "@smoke",
       plugin = {
                "pretty",
               "html:target/cucumber.html",
               "json:target/cucumber.json",
               "junit:target/cukes.xml",
               "rerun:target/rerun.text"

       }

        )

public class runner extends AbstractTestNGCucumberTests {

}
