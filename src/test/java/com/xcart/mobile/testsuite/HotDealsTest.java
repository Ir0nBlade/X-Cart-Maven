package com.xcart.mobile.testsuite;

import com.xcart.mobile.pages.BestSellerPage;
import com.xcart.mobile.pages.HomePage;
import com.xcart.mobile.pages.SalePage;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;

public class HotDealsTest extends TestBase {

    HomePage homePage = new HomePage();
    SalePage salePage = new SalePage();
    BestSellerPage bestSellerPage = new BestSellerPage();

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        homePage.mouseHoverOnHotDeals();
        homePage.clickOnSaleLink();
        salePage.verifySaleText();
        salePage.mouseHoverOnSortBy();
        salePage.clickOnNameAToZ();
        salePage.verifyProductAreInAscendingOrder();
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        homePage.mouseHoverOnHotDeals();
        homePage.clickOnSaleLink();
        salePage.verifySaleText();
        salePage.mouseHoverOnSortBy();
        salePage.clickOnPriceLowToHigh();
        salePage.verifyProductsAreSortedByLowToHigh();
    }

    @Test
    public void vefirySalesProductsArrangedByRates() throws InterruptedException {
        homePage.mouseHoverOnHotDeals();
        homePage.clickOnSaleLink();
        salePage.verifySaleText();
        salePage.mouseHoverOnSortBy();
        salePage.clickArrangeByRates();
        salePage.verifyBestSellersProductsArrangeByRates();
    }

    //********************    BestSeller   ********************
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        homePage.mouseHoverOnHotDeals();
        homePage.clickOnBestsellerLink();
        bestSellerPage.verifyBestsellerText();
        bestSellerPage.mouseHoverOnSortBy();
        bestSellerPage.clickOnNameZToA();
        bestSellerPage.verifyProductAreInDescendingOrder();
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        homePage.mouseHoverOnHotDeals();
        homePage.clickOnBestsellerLink();
        bestSellerPage.verifyBestsellerText();
        bestSellerPage.mouseHoverOnSortBy();
        bestSellerPage.clickOnPriceHighToLow();
        bestSellerPage.verifyProductsAreSortedByHighToLow();
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        homePage.mouseHoverOnHotDeals();
        homePage.clickOnBestsellerLink();
        bestSellerPage.verifyBestsellerText();
        bestSellerPage.mouseHoverOnSortBy();
        bestSellerPage.clickArrangeByRates();
        bestSellerPage.verifyBestSellersProductsArrangeByRates();

    }
}
