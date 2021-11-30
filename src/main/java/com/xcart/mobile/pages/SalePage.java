package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SalePage extends Utility {

    By salePageText = By.xpath("//h1[contains(text(),'Sale')]");
    By sortByLabel = By.xpath("//span[@class='sort-by-label']");
    By nameAToZ = By.xpath("//a[contains(text(),'Name A - Z')]");
    By priceLowToHigh = By.xpath("//a[contains(text(),'Price Low - High')]");
    By arrangeByRates = By.xpath("//a[contains(text(),'Rates')]");
    By nameZToA = By.xpath("//a[contains(text(),'Name Z - A')]");
    By priceHighToLow = By.xpath("//a[contains(text(),'Price High - Low')]");


    public void verifySaleText() {
        verifyText("Sale", salePageText, "Error, 'Sale' text not displayed as expected");
    }

    public void mouseHoverOnSortBy() {
        mouseHover(sortByLabel);
    }

    public void clickOnNameAToZ() {
        mouseHoverAndClick(nameAToZ);
    }

    public void clickOnPriceLowToHigh() {
        mouseHoverAndClick(priceLowToHigh);
    }

    public void clickArrangeByRates() {
        mouseHoverAndClick(arrangeByRates);
    }

    public void clickOnNameZToA() {
        mouseHoverAndClick(nameZToA);
    }

    public void clickOnPriceHighToLow() {
        mouseHoverAndClick(priceHighToLow);
    }


    By avengersPlush = By.xpath("//a[@class='product-thumbnail next-previous-assigned']");
    By addToCart = By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]");
    By addToCartAlert = By.xpath("//li[@class='info']");
    By yourCart = By.xpath("//div[@title='Your cart']");
    By viewCart = By.xpath("//a[@class='regular-button cart']");

    public void mouseHoverOnAvengersPlush() {
        mouseHover(avengersPlush);
    }

    public void addToCartAvengersPlush() {
        waitUnitVisibilityOfElementLocated(addToCart, 10);
        mouseHoverAndClick(addToCart);
    }
    public void verifyAddToCartAlert() {
        verifyText("Product has been added to your cart", addToCartAlert, "Error, message not displayed as expected");
    }
    public void clickOnYourCart() {
        clickOnElement(yourCart);
    }

    public void clickOnViewCart() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(viewCart);
    }


    //******************* Sort Products by Name A - Z *************************

    By productTitle = By.xpath("//h5[@class='product-name']");

    public void verifyProductAreInAscendingOrder() {
        List<WebElement> originalList = driver.findElements(productTitle);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }

        Collections.sort(originalProductNameList);
        System.out.println(originalProductNameList);

        List<WebElement> afterSortingList = driver.findElements(productTitle);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Product not sorted", originalProductNameList, afterSortingProductName);
    }


    //******************* Sort products by Price Low To High ***********************

    By productPrice = By.xpath("//li[@class='product-price-base']");

    public void verifyProductsAreSortedByLowToHigh() {
        List<WebElement> originalList = driver.findElements(productPrice);
        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductPriceList.add(Double.valueOf(product.getText().replace("$", "")));
        }
        System.out.println("Before Sorting: " + originalProductPriceList);

        List<WebElement> afterSortingList = driver.findElements(productPrice);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(product.getText().replace("$", "")));
        }
        Collections.sort(originalProductPriceList);
        System.out.println("After Sorting: " + afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList, afterSortingProductPrice);
    }


    //******************* Sort products by Ratings ***********************

    By productRatings = By.cssSelector(".stars-row.full");

    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(productRatings);
        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating : originalList) {
            originalProductRating.add(Integer.parseInt(rating.getAttribute("style").substring(7, 9)));
        }
        Collections.sort(originalProductRating, Collections.reverseOrder());
        System.out.println(originalProductRating);

        Thread.sleep(3000);
        List<WebElement> afterSortingList = driver.findElements(productRatings);
        List<Integer> afterSortingProductRating = new ArrayList<>();
        for (WebElement rating : afterSortingList) {
            afterSortingProductRating.add(Integer.parseInt(rating.getAttribute("style").substring(7, 9)));
        }
        System.out.println(afterSortingProductRating);
        Assert.assertEquals(originalProductRating, afterSortingProductRating);
    }
}

