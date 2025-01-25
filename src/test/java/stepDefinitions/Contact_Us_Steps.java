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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }


    public static ChromeDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(chromeOptions);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
       // System.out.println("Test1");
       // throw new io.cucumber.java.PendingException();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AuroFN" + generateRandomNumber(5));
      //  System.out.println("Test2");
      // throw new io.cucumber.java.PendingException();
    }

    //here adding a random name generator
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
      //  System.out.println("Test3");
     //   throw new io.cucumber.java.PendingException();
    }

    public String generateRandomNumber(int lenght) {
        return RandomStringUtils.randomNumeric(lenght);
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        System.out.println("Test4");
      //  throw new io.cucumber.java.PendingException();
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment(){
        System.out.println("Test5");
      //  throw new io.cucumber.java.PendingException();
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button(){
        System.out.println("Test6");
       // throw new io.cucumber.java.PendingException();
    }

    @Then("I should be presented with the successful contact us submission message")
    public void i_should_be_presented_with_the_successful_contact_us_submission_message(){
        System.out.println("Test7");
      //  throw new io.cucumber.java.PendingException();
    }




}
