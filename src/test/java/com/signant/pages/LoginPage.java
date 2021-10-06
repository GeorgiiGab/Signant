package com.signant.pages;

import com.signant.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this); }

    @FindBy(id = "username")
    public WebElement usernameLogin;

    @FindBy(id = "password")
    public WebElement passwordLogin;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

}
