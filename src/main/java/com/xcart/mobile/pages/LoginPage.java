package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By logInText = By.xpath("//h3[contains(text(),'Log in to your account')]");
    By email = By.id("email");
    By continueBtn = By.xpath("//span[contains(text(),'Continue')]");

    public void verifyLogInToYourAccountText(){
        verifyText("Log in to your account", logInText, "Error, Message not displayed as expected");
    }
    public void inputEmail(){
        sendTextToElement(email, getRandomEmail());
    }
    public void clickOnContinueButton(){
        clickOnElement(continueBtn);
    }
}
