package com.signant.step_definitions;

import com.signant.pages.LoginPage;
import com.signant.pages.MainViewPage;
import com.signant.pages.StarterPage;
import com.signant.utilities.BrowserUtilities;
import com.signant.utilities.ConfigurationReader;
import com.signant.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InformationViewStepDef {

    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        StarterPage starterPage = new StarterPage();

        Driver.get().get(ConfigurationReader.get("url"));

        starterPage.loginButton.click();
    }

    @When("the user enters valid {string} and {string} and clicks login button")
    public void the_user_enters_valid_and_and_clicks_login_button(String username, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.usernameLogin.sendKeys(username);
        loginPage.passwordLogin.sendKeys(password);

        loginPage.loginButton.click();
    }

    @Then("the user should be able to view his information on the main view page")
    public void the_user_should_be_able_to_view_his_information_on_the_main_view_page() {
        MainViewPage mainViewPage = new MainViewPage();
        mainViewPage.tableOfInfo.isDisplayed();
    }

    @When("user enters invalid username {string} and password {string}")
    public void user_enters_invalid_username_and_password(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameLogin.sendKeys(username);
        loginPage.passwordLogin.sendKeys(password);

        loginPage.loginButton.click();
    }

    @Then("the user should be able to see the warning message")
    public void the_user_should_be_able_to_see_the_warning_message() {
        WebElement warningMessage1 = Driver.get().findElement(By.xpath("//h1[.='Login Failure']"));

        Assert.assertTrue(warningMessage1.isDisplayed());

        WebElement warningMessage2 = Driver.get().findElement(By.xpath("//section//p[1]"));

        Assert.assertTrue(warningMessage2.isDisplayed());
    }

}
