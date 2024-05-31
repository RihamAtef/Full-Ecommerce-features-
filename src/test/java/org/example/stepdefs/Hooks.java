package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

  public class Hooks {

   public static WebDriver driver;
    @Before
    public void OpenBrowser()
    {
 driver = new EdgeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.get("https://demo.nopcommerce.com/");

    }
    @After
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);

driver.quit();
    }
}
