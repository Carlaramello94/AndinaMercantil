package com.andina;

import java.util.function.Function;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;



public class TestBase {
	
	public WebDriver driver;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void TearDown() {
		driver.close();
		driver.quit();
	}
	public void Selectdroptdown(String tipovivienda){
		Select dropdown = new Select(driver.findElement(By.id("tipovivienda")));
		dropdown.selectByVisibleText(tipovivienda);
		
	}
	public void Selectdpn(String superficie){
		Select dropdown = new Select(driver.findElement(By.id("superficie")));
		dropdown.selectByVisibleText(superficie);
	}
	public void SelectdpnUbicacion(String ubicacion){
		Select dropdown = new Select(driver.findElement(By.id("ubicacion")));
		dropdown.selectByVisibleText(ubicacion);
	}
	
	public void WaitSecond(int Seconds) throws InterruptedException {
		int Value = Seconds * 1000;
		Thread.sleep(Value);
	}


	public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

	    public void pressEnterKey() {
	        Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        robot.keyPress(KeyEvent.VK_ENTER);
	        
	    }
	    public void presstabKey() {
	        Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        robot.keyPress(KeyEvent.VK_TAB);
	       
	    }

}
