package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    WebDriver driver;

    @Before
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
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

    @After
    public void tearDown(){
        this.driver.quit();
    }
    @Given("The user is on the Contact Us Page")
    public void the_user_is_on_the_contact_us_page() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
        Thread.sleep(3000);
    }
    @When("The user enters first name")
    public void the_user_enters_first_name() {
        driver.findElement(By.cssSelector("[name=\"first_name\"]")).sendKeys("Joe");
    }
    @And("The user enters last name")
    public void the_user_enters_last_name() {
        driver.findElement(By.cssSelector("[name=\"last_name\"]")).sendKeys("Blogs");
    }
    @And("The user enters an email address")
    public void the_user_enters_an_email_address() {
        driver.findElement(By.name("email")).sendKeys("joe_blogs123@mail.com");
    }
    @And("The user enters a comment")
    public void the_user_enters_a_comment() {
        driver.findElement(By.name("message")).sendKeys("Hello how are you?");
    }
    @And("The user clicks on Submit Button")
    public void the_user_clicks_on_submit_button() {
        driver.findElement(By.cssSelector("[value=\"SUBMIT\"]")).click();
    }
    @Then("The user be presented with a successful Contact Us submission message")
    public void the_user_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }
}