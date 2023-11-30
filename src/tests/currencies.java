package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.lang.Thread.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class currencies {
    WebDriver driver = new FirefoxDriver();
    @BeforeMethod
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @Test
    public void nopeCurrencies() {
        // Find the dropdown element by its ID
        WebElement dropdown = driver.findElement(By.id("customerCurrency"));

        // Create a Select object with the dropdown element
        Select select = new Select(dropdown);

        // Select an option by visible text
        select.selectByVisibleText("Euro");

        List<String> xPaths = new ArrayList<>();
        xPaths.add("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[1]/span");
        xPaths.add("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[1]/span");
        xPaths.add("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[1]/span");
        xPaths.add("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[4]/div/div[2]/div[3]/div[1]/span");

        for (String xpath : xPaths) {
            String currency = driver.findElement(By.xpath(xpath)).getText();
            Assert.assertTrue(currency.contains("€"));
        }

    }
    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}


