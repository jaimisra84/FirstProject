package com.TestNGTest;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTestngTest {
    WebDriver driver;

    @BeforeTest
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        chromeOptions.addArguments("--ignore-certificate-errors");
        /* For Remote Docker Execution*/
        driver = new RemoteWebDriver(chromeOptions);

        /* For local execution
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();*/
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
        Thread.sleep(3000);
        System.out.println("Hello MOTO!!!");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}