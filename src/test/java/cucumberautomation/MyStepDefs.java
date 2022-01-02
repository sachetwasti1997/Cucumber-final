package cucumberautomation;

import cucumberautomation.factory.DriverFactory;
import cucumberautomation.pages.CartPage;
import cucumberautomation.pages.CheckOutPage;
import cucumberautomation.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class MyStepDefs {

    private WebDriver webDriver;

    @Given("I'm on the Store page")
    public void iMOnTheStorePage() {
        webDriver = DriverFactory.getWebDriver();
        new StorePage(webDriver).load("https://askomdch.com/store");
    }

    @When("I add a {string} in the cart")
    public void iAddAInTheCart(String productName) throws InterruptedException {
        new StorePage(webDriver).addToCart(productName);
    }

    @Then("I see {int} {string} in the cart")
    public void iSeeInTheCart(int productQuantity, String productName) {
        CartPage cartPage = new CartPage(webDriver);
        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(productQuantity, cartPage.getProductQuantity());
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        webDriver = DriverFactory.getWebDriver();
        new StorePage(webDriver).load("https://askomdch.com/store");
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        new StorePage(webDriver).addToCart("Blue Shoes");
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        new CartPage(webDriver).checkOut();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails(List<Map<String, String>> billingDetails) {

        new CheckOutPage(webDriver).setBillingDetails(
            billingDetails.get(0).get("firstname"),
            billingDetails.get(0).get("lastname"),
            billingDetails.get(0).get("address_line1"),
            billingDetails.get(0).get("city"),
            billingDetails.get(0).get("state"),
            billingDetails.get(0).get("zip"),
            billingDetails.get(0).get("email")
        );


    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        new CheckOutPage(webDriver).placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {
        Assert.assertEquals("Thank you. Your order has been received.", new CheckOutPage(webDriver).getNotice());
    }
}
