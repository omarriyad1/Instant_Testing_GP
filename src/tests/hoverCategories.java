package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class hoverCategories {
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
    public void nopeSearach1() {


        WebElement elementToHoverOver = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));

        // Create Actions class instance
        Actions actions = new Actions(driver);

        // Move to the element and perform the hover action
        actions.moveToElement(elementToHoverOver).perform();

        // Find the element to click after the hover
        WebElement elementToClick = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a"));

        // Click on the element after hovering
        elementToClick.click();

        String txt = driver.findElement(By.className("center-2")).getText();
        Assert.assertTrue(txt.contains("Notebooks"));


    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}


