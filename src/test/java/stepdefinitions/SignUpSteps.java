package stepdefinitions;

import io.cucumber.java.en.*;

import org.junit.Assert;

import pages.BaseClass;
import pages.SignUpPage;

public class SignUpSteps extends BaseClass {

    SignUpPage signUp;
    
    @Given("I am on the Magento sign-up page")
    public void i_am_on_the_magento_signUp_page() {
        //driver is initialized
        initializeDriver(); 
        signUp = new SignUpPage(driver);
        //Navigate to SignUp page
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @When("I fill the sign-up form with {string} {string} {string} {string} {string}")
    public void fill_signup_form(String fname, String lname, String email, String pass, String confirm) {
        signUp.enterFirstName(fname);
        signUp.enterLastName(lname);
        signUp.enterEmail(email.replace("<timestamp>", String.valueOf(System.currentTimeMillis())));
        signUp.enterPassword(pass);
        signUp.enterConfirmPassword(confirm);
    }

    @When("I click on the Create an Account button")
    public void clickCreateAccount() {
        signUp.clickCreateButton();
    }

    @Then("I should see validation messages for required fields")
    public void verifyRequiredFieldErrors() {
        Assert.assertTrue(signUp.getAllRequiredErrorsDisplayed());
    }

    @Then("I should see an email validation error")
    public void emailValidationError() {
        String errorText = signUp.getEmailError();
        System.out.println("Email error: " + errorText);
        Assert.assertTrue("Expected email validation error not shown",
            errorText.contains("Please enter a valid email address"));
    }


    @Then("I should see password mismatch error")
    public void mismatchError() {
        String errorMsg = signUp.getPasswordMismatchError();
        System.out.println("Password mismatch error: " + errorMsg);
        Assert.assertTrue("Mismatch error not shown!",
            errorMsg.contains("same value again"));
    }


    @Then("I should be redirected to the dashboard")
    public void successfulSignup() {
        Assert.assertTrue(driver.getCurrentUrl().contains("customer/account"));
    }
}
