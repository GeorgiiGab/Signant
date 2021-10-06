package com.signant.pages;

import com.signant.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StarterPage {

    public StarterPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href='/register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;





}
