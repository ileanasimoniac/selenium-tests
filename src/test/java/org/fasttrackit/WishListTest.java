package org.fasttrackit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {



   private static WebDriver driver;

    @BeforeClass
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void doLogin() {
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
    }

    @Test
    public void validAccessWhishlist() {
        this.doLogin();
        driver.get("https://fasttrackit.org/selenium-test/wishlist/index/");
        Assert.assertEquals(driver.findElement(By.cssSelector(".page-title.title-buttons > h1")).getText().toLowerCase(), "My Wishlist".toLowerCase());
    }

    @Test
    public void validAddToWhishList() {
        this.doLogin();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement saleButton = driver.findElement(By.cssSelector("#header #header-nav #nav .nav-5 > a"));
        saleButton.click();
        WebElement firstProduct = driver.findElement(By.cssSelector(".main .category-products ul.products-grid .item > a"));
        firstProduct.click();
        WebElement addToWishListButton = driver.findElement(By.cssSelector("a.link-wishlist"));
        addToWishListButton.click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".page-title.title-buttons > h1")).getText().toLowerCase(), "My Wishlist".toLowerCase());
    }

    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
