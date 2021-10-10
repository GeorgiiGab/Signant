package com.signant.step_definitions;

import com.signant.pages.RegistrationPage;
import com.signant.pages.StarterPage;
import com.signant.utilities.BrowserUtilities;
import com.signant.utilities.ConfigurationReader;
import com.signant.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RegisterStepDef {

    RegistrationPage registrationPage = new RegistrationPage();

    @Given("the user is on starter page")
    public void the_user_is_on_starter_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user clicks on the register button and navigates to registration page")
    public void the_user_clicks_on_the_register_button_and_navigates_to_registration_page() {

        StarterPage starterPage = new StarterPage();
        starterPage.registerButton.click();
    }

    @When("the user fills in the registration information")
    public void the_user_fills_in_the_registration_information(Map<String, String> registerInfo) {
        BrowserUtilities.waitForPageToLoad(3);

        registrationPage.registeringNewUser(registerInfo.get("username"), registerInfo.get("password"), registerInfo.get("firstName"), registerInfo.get("familyName"), registerInfo.get("phoneNumber"));

    }

    @Then("the user should be transferred to login page")
    public void the_user_should_be_transferred_to_login_page() {
      BrowserUtilities.waitForPageToLoad(3);

        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Log In - Demo App";

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("the user doesn't fill the username field during registration")
    public void the_user_doesn_t_fill_the_username_field_during_registration() {
        registrationPage.password.sendKeys("zxc123");
        registrationPage.firstName.sendKeys("Alex");
        registrationPage.familyName.sendKeys("Smith");
        registrationPage.phoneNumber.sendKeys("46342034");

        registrationPage.registerButton.click();

    }

    @Then("the user should see the warning message {string} after not filling the {string} field")
    public void the_user_should_see_the_warning_message_after_not_filling_the_field(String message, String field) {

        String expectedMessage = message;

        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        WebElement emptyField = Driver.get().findElement(By.id(field));
        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", emptyField);

        String actualMessage = Driver.get().findElement(By.id(field)).getAttribute("validationMessage");

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the user puts the username {string} that is already taken")
    public void the_user_puts_the_username_that_is_already_taken(String username) {
        registrationPage.username.sendKeys(username);
        registrationPage.password.sendKeys("zxc123");
        registrationPage.firstName.sendKeys("Alex");
        registrationPage.familyName.sendKeys("Smith");
        registrationPage.phoneNumber.sendKeys("46342034");

        registrationPage.registerButton.click();
    }

    @Then("the user should see the warning message that the user {string} is already registered")
    public void the_user_should_see_the_warning_message_that_the_user_is_already_registered(String string) {
        WebElement warningMessage = Driver.get().findElement(By.className("flash"));

        Assert.assertTrue(warningMessage.isDisplayed());
    }

}
