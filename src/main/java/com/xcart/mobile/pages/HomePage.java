package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By shippingLink = By.xpath("(//span[contains(text(),'Shipping')])[2]");
    By shippingPage = By.xpath("//h1[contains(text(),'Shipping')]");
    By newPageLink = By.xpath("(//span[contains(text(),'New!')])[2]");
    By newPage = By.xpath("//h1[contains(text(),'New arrivals')]");
    By comingSoonLink = By.xpath("(//span[contains(text(),'Coming soon')])[2]");
    By comingSoonPage = By.xpath("//h1[contains(text(),'Coming soon')]");
    By contactUsLink = By.xpath("(//span[contains(text(),'Contact us')])[2]");
    By contactUsPage = By.xpath("//h1[contains(text(),'Contact us')]");


    public void clickOnShippingLink() {
        clickOnElement(shippingLink);
    }
    public void clickOnNewLink() {
        clickOnElement(newPageLink);
    }
    public void clickOnComingSoonLink() {
        clickOnElement(comingSoonLink);
    }
    public void clickOnContactUsLink() {
        clickOnElement(contactUsLink);
    }
    public void verifyShippingpageText() {
        verifyText("Shipping", shippingPage, "Error, 'Shipping' message not displayed as expectee");
    }
    public void verifyNewpageText() {
        verifyText("New arrivals", newPage, "Error, 'New arrivals' message not displayed as expectee");
    }
    public void verifyComingSoonPageText() {
        verifyText("Coming soon", comingSoonPage, "Error, 'Coming soon' message not displayed as expectee");
    }
    public void verifyContactUsPageText() {
        verifyText("Contact us", contactUsPage, "Error, 'Contact us' message not displayed as expectee");
    }


    By hotDealsLink = By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]");
    By saleLink = By.xpath("(//span[contains(text(),'Sale')])[2]");
    By bestsellerLink = By.xpath("(//span[contains(text(),'Bestsellers')])[2]");


    public void mouseHoverOnHotDeals(){
        mouseHover(hotDealsLink);
    }
    public void clickOnSaleLink(){
        mouseHoverAndClick(saleLink);
    }
    public void clickOnBestsellerLink(){
        mouseHoverAndClick(bestsellerLink);
    }


}
