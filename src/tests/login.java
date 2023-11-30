package tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static java.lang.Thread.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver = new FirefoxDriver();
    @BeforeMethod

    public void openBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");


    }




    @Test
    public void ValidLoginn()
    {
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("omarriyadd@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("pasw***");
        driver.findElement(By.className("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");



    }
    @Test
    public void inValidLoginn()
    {
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("111111111111");
        driver.findElement(By.name("Password")).sendKeys("mzkz");
        driver.findElement(By.className("login-button")).click();
        String buttonf3lnn = driver.findElement(By.className("page-title")).getText();
        Assert.assertTrue(buttonf3lnn.contains("Welcome, Please Sign In!"));
    }

    @Test(priority = 1)
    public void emptyLoginn()
    {
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.className("login-button")).click();
        String buttonf3lnn = driver.findElement(By.className("page-title")).getText();
        Assert.assertTrue(buttonf3lnn.contains("Welcome, Please Sign In!"));

    }


    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}


