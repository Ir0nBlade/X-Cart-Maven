package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class OrderPage extends Utility {

    By yourOrderText = By.id("page-title");

    public void verifyOrderPageTitleText(){
        verifyText("Thank you for your order", yourOrderText, "Error, Page Title not displayed as expected");
    }
}
