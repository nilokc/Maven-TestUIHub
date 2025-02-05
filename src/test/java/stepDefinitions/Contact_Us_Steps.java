package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before("@Contact_Us")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
      //  System.setProperty("webdriver.http.factory", "jdk-http-client");
    }


    public static ChromeDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(chromeOptions);
    }

    @After("@Contact_Us")
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

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_nil(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        System.out.println(firstName);
    }

    @And("I enter specific last name {word}")
    public void i_enter_specific_last_name_blogs(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
        System.out.println(lastName);
    }

    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_nil_blogs123_mail(String email) {
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys(email);
        System.out.println(email);
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


    private String generatedEmail;
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        generatedEmail = "AutoEmail" + generateRandomNumber(10) + "@mail.com";
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys(generatedEmail);
      //  driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys("Auto email" + generateRandomNumber(10) + "mail.com");
        System.out.println("Enter Random/Generated Email");
        System.out.println("Generated Email: " + generatedEmail);
      //  throw new io.cucumber.java.PendingException();
    }



    @And("I enter a unique comment")
    public void i_enter_a_unique_comment(){
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Hello World" + generateRandomNumber(20));
        System.out.println("Test Entering Random Comment");
      //  throw new io.cucumber.java.PendingException();
    }


    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys(comment);
        System.out.println(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button(){
        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
        System.out.println("Click/Test on Submit Button");



     //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_message"))); // Replace with actual locator for the success message
       // throw new io.cucumber.java.PendingException();
    }


    @Then("I should be presented with the successful contact us submission message")
    public void i_should_be_presented_with_the_successful_contact_us_submission_message(){
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
        System.out.println("Successful Login Message Verify Step");
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("I should be presented with a unsuccessful contact us submission message")
    public void i_should_be_presented_with_a_unsuccessful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("/html/body"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Error: Invalid email address");
        System.out.println("Unsuccessful Login Message Verify Step");
    }



}
