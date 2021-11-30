package com.xcart.mobile.utility;

import com.google.common.base.Function;
import com.xcart.mobile.drivermanager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.Random;

public class Utility extends DriverManager {

    // This method will click on element
    public void clickOnElement(By by) {
        WebElement link = driver.findElement(by);
        link.click();
    }

    // This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // This method will send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // This method will send text to element
    public void sendKeysToElement(By by, CharSequence keys) {
        driver.findElement(by).sendKeys(keys);

    }

    // This method will select value from drop down menu
    public void selectByValueFromDropdown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }

    // This method will select option matching text
    public void selectByVisibleTextFromDropdown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    // This method will select option matching value
    public void selectByIndexFromDropdown(By by, int index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    // This method will mouse hover and click the element
    public void mouseHoverAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
//        Thread.sleep(3000);
        waitUnitVisibilityOfElementLocated(by, 3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }

    // This method will mouse hover on element
    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
//        Thread.sleep(3000);
        waitUnitVisibilityOfElementLocated(by,2000);
        actions.moveToElement(mouseHoover).build().perform();
    }


    // This method will verify text displayed on web page
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    // Thbis method will generate random email
    public String getRandomEmail() {
        String saltChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        while (email.length() < 10) {
            int index = (int) (random.nextFloat() * saltChars.length());
            email.append(saltChars.charAt(index));
        }
        String saltStr = (email.toString() + "@gmail.com");
        return saltStr;
    }


    public void dismissAlert(){
        Alert alert = driver.switchTo().alert();    // Creating alert object reference
        alert.dismiss();
    }

    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        System.out.println(textOnAlert);
        return textOnAlert;
    }

    public void dragAndDrop(By drag, By drop){

        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);
        actions.dragAndDrop(draggable,droppable).build().perform();

    }

    // This method will use to wait until visiblity of element
    public WebElement waitUnitVisibilityOfElementLocated(By by, int time){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // This method is for Fluent wait
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    public void verifyMessageText(String exceptedMessage, String actualMessage, @Nullable String errorMessage) {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }


}
