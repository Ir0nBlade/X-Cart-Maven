package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ShoppingCartPage extends Utility {

    By shoppingText = By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]");
    By quantity = By.xpath("//input[contains(@id, 'amount16')]");
    By shoppingTextForTwo = By.xpath("//h1[contains(text(),'Your shopping cart - 2 items')]");
    By subtotalBeforeDecimal = By.xpath("//ul[@class='sums']//span[@class='part-integer'][normalize-space()='29']");
    By subtotalAfterDecimal = By.xpath("//ul[@class='sums']//span[@class='part-decimal'][normalize-space()='98']");
    By totalBeforeDecimal = By.xpath("//span[contains(text(),'36')]");
    By totalAfterDecimal = By.xpath("//span[contains(text(),'00')]");
    By goToCheckoutBtn = By.xpath("//span[contains(text(),'Go to checkout')]");
    By emptyCartLink = By.xpath("//a[contains(text(),'Empty your cart')]");
    By itemDeletedText = By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]");
    By closePopUp = By.xpath("//a[@title='Close']");
    By cartEmptyText = By.xpath("//h1[contains(text(),'Your cart is empty')]");


    public void verifyShoppingCartText(){
        verifyText("Your shopping cart - 1 item", shoppingText, "Error, message not displayed as expected");
    }
    public void changeQuantiy(){
        sendTextToElement(quantity, Keys.BACK_SPACE+"2");
    }
    public void verifyShoppingCartTextForTwoItem(){
        verifyText("Your shopping cart - 2 items", shoppingTextForTwo, "Error, message not displayed as expected");
    }
    public void verifySubtotal(){
        verifyText("29", subtotalBeforeDecimal, "Error, Message not displayed as expected");
        verifyText("98", subtotalAfterDecimal, "Error, Message not displayed as expected");
    }
    public void verifyTotal(){
        verifyText("36", totalBeforeDecimal, "Error, Message not displayed as expected");
        verifyText("00", totalAfterDecimal, "Error, Message not displayed as expected");
    }
    public void clickOnGoToCheckoutButton(){
        clickOnElement(goToCheckoutBtn);
    }
    public void clickOnEmptyYourCart(){
        clickOnElement(emptyCartLink);
    }
    public void verifyClearYourCartAlertMessage() throws InterruptedException {
        Thread.sleep(2000);
        String message = getTextFromAlert();
        verifyMessageText("Are you sure you want to clear your cart?", message, "Error, Message not displayed as expected");
        acceptAlert();
    }
    public void verifyItemsDeletedFromCartText(){
        verifyText("Item(s) deleted from your cart", itemDeletedText, "Error, Message not displayed as expected");
    }
    public void setClosePopUp(){
        clickOnElement(closePopUp);
    }
    public void verifyYourCartIsEmptyText(){
        verifyText("Your cart is empty", cartEmptyText, "Error, Message not displayed as expected");
    }



}
