package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {

    By secureCheckout = By.xpath("//h1[contains(text(),'Secure Checkout')]");
    By firstName = By.id("shippingaddress-firstname");
    By lastName = By.id("shippingaddress-lastname");
    By addressStreet = By.id("shippingaddress-street");
    By addressCity = By.id("shippingaddress-city");
    By addressCountry = By.id("shippingaddress-country-code");
    By addressState = By.id("shippingaddress-custom-state");
    By addressZipcode = By.id("shippingaddress-zipcode");
    By createProfile = By.id("create_profile");
    By password = By.id("password");
    By localShipping = By.id("method128");
    By paymentMethod = By.id("pmethod6");
    By total = By.xpath("//span[contains(text(),'$37.03')]");
    By placeOrderBtn = By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']");

    public void verifySecureCheckoutText(){
        verifyText("Secure Checkout", secureCheckout, "Error, Message not displayed as expected");
    }
    public void inputFirstName(){
        sendTextToElement(firstName,"Peter");
    }
    public void inputLastName(){
        sendTextToElement(lastName,"Patel");
    }
    public void inputAddressStreet(){
        sendTextToElement(addressStreet,"10 Downing Street");
    }
    public void inputAddressCity(){
        sendTextToElement(addressCity,"London");
    }
    public void inputAddressCountry(){
        selectByVisibleTextFromDropdown(addressCountry, "United Kingdom");
    }
    public void inputAddressState(){
        sendTextToElement(addressState, "West Sussex");
    }
    public void inputAddressZipcode(){
        sendTextToElement(addressZipcode, "1");
    }
    public void selectCreateProfile(){
        clickOnElement(createProfile);
    }
    public void inputPassword(){
        sendTextToElement(password, "abc123");
    }
    public void selectDeliveryMethod(){
        clickOnElement(localShipping);
    }
    public void selectPaymentMethod(){
        clickOnElement(paymentMethod);
    }
    public void verifyTotalPrice(){
        verifyText("Place order: $37.03", total, "Error, Total amount not displayed as expected");
    }
    public void clickOnPlaceOrderButton() throws InterruptedException {
//        waitUnitVisibilityOfElementLocated(placeOrderBtn,10);
        Thread.sleep(2000);
        clickOnElement(placeOrderBtn);
    }

}
