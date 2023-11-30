package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static java.lang.Thread.*;
public class search {
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
    public void nopeSearach1()
    {
        driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]")).sendKeys("Book");

        driver.findElement(By.xpath(" //button[@class=\"button-1 search-box-button\"]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q=Book");
    }
    @Test
    public void nopeSearach2()
    {
        driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]")).sendKeys("SCI_FAITH");

        driver.findElement(By.xpath(" //button[@class=\"button-1 search-box-button\"]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q=SCI_FAITH");
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
