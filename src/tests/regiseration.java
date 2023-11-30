package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static java.lang.Thread.*;

public class regiseration {
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
    public void ValidRegister() {

        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("omar");
        driver.findElement(By.id("LastName")).sendKeys("omar");

        driver.findElement(By.id("Email")).sendKeys("omarriyaddd@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("pasw***");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("pasw***");
        driver.findElement(By.id("register-button")).click();
        String txt = driver.findElement(By.className("result")).getText();
        Assert.assertTrue(txt.contains("Your registration completed"));

    }
//    @Test
//    public void inValidRegister() {
//
//        driver.findElement(By.className("ico-register")).click();
//        driver.findElement(By.id("FirstName")).sendKeys("msh-omar");
//        driver.findElement(By.id("LastName")).sendKeys("elkbeer");
//
//        driver.findElement(By.id("Email")).sendKeys("msh-elkbeer");
//        driver.findElement(By.id("Password")).sendKeys("msh-elpasw***");
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("msh-pasw***");
//        driver.findElement(By.id("register-button")).click();
//        boolean buttonf3ln = driver.findElement(By.id("register-button")).isDisplayed();
//        Assert.assertTrue(buttonf3ln);
//    }
//    @Test
//    public void emptyRegister() {
//
//        driver.findElement(By.className("ico-register")).click();
//        driver.findElement(By.id("FirstName")).sendKeys("  ");
//        driver.findElement(By.id("LastName")).sendKeys("  ");
//
//        driver.findElement(By.id("Email")).sendKeys(" ");
//        driver.findElement(By.id("Password")).sendKeys("    ");
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("     ");
//        driver.findElement(By.id("register-button")).click();
//        boolean button4 = driver.findElement(By.id("register-button")).isDisplayed();
//        Assert.assertTrue(button4);
//    }
    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}






