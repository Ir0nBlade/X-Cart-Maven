package com.xcart.mobile.testsuite;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase {

    HomePage homePage = new HomePage();
    SalePage salePage = new SalePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LoginPage loginPage = new LoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    OrderPage orderPage = new OrderPage();
    BestSellerPage bestSellerPage = new BestSellerPage();


    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {
        homePage.mouseHoverOnHotDeals();
        homePage.clickOnSaleLink();

        salePage.verifySaleText();
        salePage.mouseHoverOnSortBy();
        salePage.clickOnNameAToZ();
        salePage.mouseHoverOnAvengersPlush();
        salePage.addToCartAvengersPlush();
        salePage.verifyAddToCartAlert();
        salePage.clickOnYourCart();
        salePage.clickOnViewCart();

        shoppingCartPage.verifyShoppingCartText();
        shoppingCartPage.changeQuantiy();
        shoppingCartPage.verifyShoppingCartTextForTwoItem();
        shoppingCartPage.verifySubtotal();
        shoppingCartPage.verifyTotal();
        shoppingCartPage.clickOnGoToCheckoutButton();

        loginPage.verifyLogInToYourAccountText();
        loginPage.inputEmail();
        loginPage.clickOnContinueButton();

        checkoutPage.verifySecureCheckoutText();
        checkoutPage.inputFirstName();
        checkoutPage.inputLastName();
        checkoutPage.inputAddressStreet();
        checkoutPage.inputAddressCity();
        checkoutPage.inputAddressCountry();
        checkoutPage.inputAddressState();
        checkoutPage.inputAddressZipcode();
        checkoutPage.selectCreateProfile();
        checkoutPage.inputPassword();
        checkoutPage.selectDeliveryMethod();
        checkoutPage.selectPaymentMethod();
        checkoutPage.verifyTotalPrice();
        checkoutPage.clickOnPlaceOrderButton();

        orderPage.verifyOrderPageTitleText();

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        homePage.mouseHoverOnHotDeals();
        homePage.clickOnBestsellerLink();
        bestSellerPage.verifyBestsellerText();
        bestSellerPage.mouseHoverOnSortBy();
        bestSellerPage.clickOnNameAToZ();

        bestSellerPage.mouseHoverOnVinylIdolzGhostbusters();
        bestSellerPage.clickOnAddToCartButton();
        bestSellerPage.verifyProductAddedToCartText();
        bestSellerPage.clickOnYourCartIcon();
        bestSellerPage.clickOnViewCartButton();

        shoppingCartPage.verifyShoppingCartText();
        shoppingCartPage.clickOnEmptyYourCart();
        shoppingCartPage.verifyClearYourCartAlertMessage();
        shoppingCartPage.verifyItemsDeletedFromCartText();
        shoppingCartPage.setClosePopUp();
        shoppingCartPage.verifyYourCartIsEmptyText();

    }

}
