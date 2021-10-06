package com.signant.pages;

import com.signant.utilities.Driver;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainViewPage {

    public MainViewPage() {
        PageFactory.initElements(Driver.get(), this); }

    @FindBy (xpath = "//table[@id='content']")
    public WebElement tableOfInfo;

    @FindBy(xpath = "//tr[2]/td[1]")
    public WebElement usernameKey;

    @FindBy(xpath = "//tr[2]/td[2]")
    public WebElement usernameValue;

    @FindBy (xpath = "//tr[3]/td[1]")
    public WebElement firstnameKey;

    @FindBy (xpath = "//tr[3]/td[2]")
    public WebElement firstnameValue;

    @FindBy (xpath = "//tr[4]/td[1]")
    public WebElement lastnameKey;

    @FindBy (xpath = "//tr[4]/td[2]")
    public WebElement lastnameValue;

    @FindBy (xpath = "//tr[5]/td[1]")
    public WebElement phoneNumberKey;

    @FindBy (xpath = "//tr[5]/td[2]")
    public WebElement phoneNumberValue;


    public Map<Object, Object> mainViewInfo(){

        Map<Object, Object> mainInfo = new LinkedHashMap<>();

        mainInfo.put("usernameKey", "usernameValue");
        mainInfo.put("firstnameKey", "firstnameVale");
        mainInfo.put("lastnameKey", "lastnameValue");
        mainInfo.put("phoneNumberKey", "phoneNUmberValue");

        return  mainInfo;

    }


}
