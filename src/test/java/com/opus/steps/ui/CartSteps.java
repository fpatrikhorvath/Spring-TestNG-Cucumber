package com.opus.steps.ui;

import com.opus.ui.CartPage;
import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class CartSteps extends CartPage {
    @Autowired
    public CartSteps(){
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }
    @Then("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        String message = "The user is not on the cart page.";
        assertTrue(isInitialized(), message);
    }
}
