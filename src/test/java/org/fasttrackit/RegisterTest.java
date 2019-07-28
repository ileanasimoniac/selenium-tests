package org.fasttrackit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    private static WebDriver driver;

    @BeforeClass
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validRegister() {
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#firstname")).sendKeys("nume1");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("nume2");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("test0005@fastrackit.org");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".my-account .dashboard ul.messages > li.success-msg span")).getText(), "Thank you for registering with Madison Island.");
    }

    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
