package com.sst.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRunner {
	
	public static void main(String[]args) throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jayesh\\Desktop\\eclipse\\chromedriver.exe");

		// declaration and instantiation of objects/variables
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev18742.service-now.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("Arminvan3#");
        driver.findElement(By.id("sysverb_login")).click();
        driver.findElement(By.id("filter")).sendKeys("incident");
        driver.findElement(By.linkText("Create New")).click();
        driver.switchTo().defaultContent();
        System.out.println("In default content");
        driver.switchTo().frame("gsft_main");
        System.out.println("In frame 1");
        Thread.sleep(5000);
        driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("Jay Hoondlani");
        driver.findElement(By.id("incident.short_description")).sendKeys("SERVER IS DOWN");
        driver.findElement(By.id("sys_display.incident.assignment_group")).sendKeys("Hardware");
        Thread.sleep(5000);
       // driver.switchTo().alert().accept();
        
        driver.findElement(By.id("sysverb_insert")).click();
        
        System.out.println("complete");
        
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame(0);
        
        driver.findElement(By.linkText("All")).click();
        
        driver.switchTo().defaultContent();
        
        driver.switchTo().frame("gsft_main");
        
        driver.findElement(By.xpath(".//html/body/div[1]/div[1]/span/div/div[5]/table[1]/tbody/tr/td/div/table/tbody/tr[1]/td[3]/a")).click();
        
        Select dropdown = new Select(driver.findElement(By.id("incident.state")));
      
        dropdown.selectByVisibleText("Acknowledged");
        driver.findElement(By.id("sysverb_update")).click();
        driver.findElement(By.linkText("INC0010109")).click();
        driver.findElement(By.xpath(".//html/body/div[2]/form/div[1]/span[3]/span/span[2]")).click();
        Select dropdown1 = new Select(driver.findElement(By.id("incident.close_code")));
        dropdown1.selectByVisibleText("Solved (Permanently)");
        driver.findElement(By.id("incident.close_notes")).sendKeys("Test");
     //   driver.findElement(By.id("resolve_incident")).click();
        
	}

}
