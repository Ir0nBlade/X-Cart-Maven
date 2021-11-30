package com.xcart.mobile.testsuite;

import com.xcart.mobile.pages.HomePage;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        homePage.clickOnShippingLink();
        homePage.verifyShippingpageText();
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        homePage.clickOnNewLink();
        homePage.verifyNewpageText();
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        homePage.clickOnComingSoonLink();
        homePage.verifyComingSoonPageText();
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        homePage.clickOnContactUsLink();
        homePage.clickOnContactUsLink();
    }

}
