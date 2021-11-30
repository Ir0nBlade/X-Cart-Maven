package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestSellerPage extends Utility {

    By bestsellerText = By.xpath("//h1[contains(text(),'Bestsellers')]");
    By sortByLabel = By.xpath("//span[@class='sort-by-label']");
    By nameAToZ = By.xpath("//a[contains(text(),'Name A - Z')]");
    By nameZToA = By.xpath("//a[contains(text(),'Name Z - A')]");
    By priceHighToLow = By.xpath("//a[contains(text(),'Price High - Low')]");
    By arrangeByRates = By.xpath("//a[contains(text(),'Rates')]");
    By vinylIdolz = By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']");
    By addToCart = By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-13')]");
    By productAddedToCartText = By.xpath("//li[@class='info']");
    By yourCartIcon = By.xpath("//div[@title='Your cart']");
    By viewCartBtn = By.xpath("//a[@class='regular-button cart']");


    public void verifyBestsellerText() {
        verifyText("Bestsellers", bestsellerText, "Error, Message not displayed as expected");
    }
    public void mouseHoverOnSortBy() {
        mouseHover(sortByLabel);
    }
    public void clickOnNameAToZ() {
        mouseHoverAndClick(nameAToZ);
    }

    public void clickOnNameZToA() {
        mouseHoverAndClick(nameZToA);
    }

    public void clickOnPriceHighToLow() {
        mouseHoverAndClick(priceHighToLow);
    }

    public void clickArrangeByRates() {
        mouseHoverAndClick(arrangeByRates);
    }

    public void mouseHoverOnVinylIdolzGhostbusters() {
        mouseHover(vinylIdolz);
    }

    public void clickOnAddToCartButton() {
        waitUnitVisibilityOfElementLocated(addToCart, 20);
        mouseHoverAndClick(addToCart);
    }

    public void verifyProductAddedToCartText() {
        verifyText("Product has been added to your cart", productAddedToCartText, "Error, Message not displayed as expected");
    }

    public void clickOnYourCartIcon() {
        clickOnElement(yourCartIcon);
    }

    public void clickOnViewCartButton() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(viewCartBtn);
    }

    //************************* Sort Products by Name Z To A ***************************//
    By productTitle = By.xpath("//h5[@class='product-name']");

    public void verifyProductAreInDescendingOrder() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> originalList = driver.findElements(productTitle);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }

        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());
        System.out.println(originalProductNameList);

        List<WebElement> afterSortingList = driver.findElements(productTitle);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 : afterSortingList) {
            afterSortingProductName.add(product1.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Product not sorted", originalProductNameList, afterSortingProductName);
    }


    //********************* Sort Products by Price High - Low ****************************//
    By productPrice = By.xpath("//ul[@class='product-price']");

    public void verifyProductsAreSortedByHighToLow() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> originalList = driver.findElements(productPrice);
        List<Double> beforeFilterPriceList = new ArrayList<>();
        for (WebElement price : originalList) {
            beforeFilterPriceList.add(Double.valueOf(price.getText().replace("$", "")));
        }
        System.out.println("Before Sorting: " + beforeFilterPriceList);
        Collections.sort(beforeFilterPriceList, Collections.reverseOrder());

        List<WebElement> afterSortingList = driver.findElements(productPrice);
        List<Double> afterSortingPriceList = new ArrayList<>();
        for (WebElement price : afterSortingList) {
            afterSortingPriceList.add(Double.valueOf(price.getText().replace("$", "")));
        }
        System.out.println("After Sorting: " + afterSortingPriceList);
        Assert.assertEquals(beforeFilterPriceList, afterSortingPriceList);
    }


    //********************* Sort Products by Ratings ****************************//

    By productRatings = By.cssSelector(".stars-row.full");

    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> originalList = driver.findElements(productRatings);
        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating : originalList) {
            originalProductRating.add(Integer.parseInt(rating.getAttribute("style").substring(7, 9)));
        }

        Collections.sort(originalProductRating, Collections.reverseOrder());
        System.out.println("Before Sorting: " + originalProductRating);

        List<WebElement> afterSortingList = driver.findElements(productRatings);
        List<Integer> afterSortingProductRating = new ArrayList<>();
        for (WebElement rating : afterSortingList) {
            afterSortingProductRating.add(Integer.parseInt(rating.getAttribute("style").substring(7, 9)));
        }
        System.out.println("After Sorting: " + afterSortingProductRating);
        Assert.assertEquals(originalProductRating, afterSortingProductRating);
    }

}

