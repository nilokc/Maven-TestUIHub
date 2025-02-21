package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login_Steps {

    private WebDriver driver;
    @Before("@login")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }


    public static ChromeDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(chromeOptions);
    }


    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("http://www.webdriveruniversity.com/Login-Portal/index.html");

    }



   @When("I enter a username {string}")
    public void i_enter_a_username_webdriver(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

   /* @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
       // driver.findElement(By.id("text")).sendKeys(username);
        driver.findElement(By.id("text")).sendKeys(username);

    }
*/

    @When("I enter a password {}")
    public void i_enter_a_password_webdriver123 (String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }


    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String loginMessage = alert.getText();
        System.out.println("Alert message: " + loginMessage);
        Assert.assertEquals("validation succeeded", loginMessage);
        alert.accept();




    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        try {
            Alert alert = driver.switchTo().alert();
            String loginMessage = alert.getText();
            Assert.assertEquals("validation failed", loginMessage);
            alert.accept(); // Close the alert
        }
        catch (NoAlertPresentException e) {
            Assert.fail("No alert was present!");
        }
    }

  /*  @When("I enter a username {word}")
    public void i_enter_a_unique_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }
*/
    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "expectedMessage");
    }






    @After("@login")
    public void tearDown() {
        driver.quit();
    }




}
