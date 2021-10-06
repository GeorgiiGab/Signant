package com.signant.pages;

import com.signant.utilities.BrowserUtilities;
import com.signant.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage() {PageFactory.initElements(Driver.get(), this); }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement familyName;

    @FindBy(id = "phone")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement registerButton;

    public void registeringNewUser(String username, String password, String firstName, String familyName, String phoneNumber){

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.firstName.sendKeys(firstName);
        this.familyName.sendKeys(familyName);
        this.phoneNumber.sendKeys("\""+phoneNumber+"\"");

        BrowserUtilities.waitFor(3);

        registerButton.click();

    }


}
