package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.junit.Assert;
import io.cucumber.java.en.*;
import pages.BaseClass;
import pages.LoginPage;

public class LoginSteps extends BaseClass{

	 LoginPage loginPage;

    @Given("I am on the Magento login page")
    public void i_am_on_the_magento_login_page() {
        //driver is initialized
        initializeDriver(); 
        loginPage = new LoginPage(driver);
        //Navigate to login page
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    @When("I enter valid login credentials")
    public void i_enter_valid_login_credentials() {
        loginPage.enterEmail("valid@email.com"); // Replace with real email
        loginPage.enterPassword("ValidPassword"); // Replace with real password
        loginPage.clickLoginButton();
    }
    
    
    @Then("I should be logged into the account successfully")
    public void i_should_be_logged_into_the_account_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("customer/account"));

    }


    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_credentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'message-error')]/div")
            ));

            String actualText = errorElement.getText();
            System.out.println("Error message captured: " + actualText);
            Assert.assertTrue("Expected error message not found!",
                    actualText.contains(expectedMessage));
        } catch (TimeoutException e) {
            System.err.println("ERROR MESSAGE NOT VISIBLE IN TIME");
            e.printStackTrace();
            Assert.fail("Timed out waiting for error message: " + expectedMessage);
        }
    }


    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
    	try
    	{
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement forgotLink = wait.until(ExpectedConditions.elementToBeClickable(
	            By.linkText(linkText)
	        ));
	        forgotLink.click();
    	}
    	catch (TimeoutException e) {
            System.out.println("Timeout: 'Forgot Your Password?' link was not clickable within 10 seconds.");
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: 'Forgot Your Password?' link is missing in DOM.");
        } catch (Exception e) {
            System.out.println("Unexpected error while clicking 'Forgot Your Password?': " + e.getMessage());
        }
    }


    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("customer/account/forgotpassword"));
    }
}
