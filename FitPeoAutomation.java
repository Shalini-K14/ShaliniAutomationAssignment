package com.Learning_JavaScript_Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeoAutomation {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver
        WebDriver driver = new ChromeDriver();
        try {
        driver.manage().window().maximize();
            // Navigate to FitPeo HomePage
            driver.get("https://fitpeo.com/");

            // Navigate to Revenue Calculator Page
            driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
            Thread.sleep(2000);

            // Scroll Down to Slider section
            WebElement slider = driver.findElement(By.xpath("//fieldset[@aria-hidden='true']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(slider).perform();
            Thread.sleep(2000);

            // Adjust Slider
            driver.findElement(By.xpath("//input[@type='range']")).sendKeys("820");
            Thread.sleep(2000);

            // Update Text Field
            WebElement textField = driver.findElement(By.xpath("//input[@type='number']"));
            textField.click();
            textField.sendKeys("560");

            // Validate Slider Value
            String sliderValue = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
            if (sliderValue.equals("560")) {
                System.out.println("Slider value updated correctly");
            } else {
                System.out.println("Slider value not updated correctly");
            }

            // Select CPT Codes
            driver.findElement(By.xpath("//span[text()='57']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='19.19']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[text()='63']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[text()='51']")).click();
            Thread.sleep(2000);

            // Validate Total Recurring Reimbursement
            String totalRecurringReimbursement = driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month']")).getText();
            if (totalRecurringReimbursement.equals("$110,700")) {
                System.out.println("Total Recurring Reimbursement is correct");
            } else {
                System.out.println("Total Recurring Reimbursement is not correct");
            }

            
        }finally{
        	// Close the browser
            driver.quit();
        }
    }
}

