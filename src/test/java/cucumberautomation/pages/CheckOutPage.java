package cucumberautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage{

    @FindBy(id = "billing_first_name") private WebElement billingFirstNameFld;
    @FindBy(id = "billing_last_name") private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1") private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateFld;
    @FindBy(id = "billing_postcode") private WebElement billingPostCodeFld;
    @FindBy(id = "billing_email") private WebElement billingEmailFld;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(id = "place_order") private WebElement placeOrderButton;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeMessage;

    public CheckOutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckOutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckOutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckOutPage enterBillingAddressOne(String billingAddressOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressOne);
        return this;
    }

    public CheckOutPage enterBillingCityFld(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckOutPage enterBillingStateDropDown(String billingState){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateFld)));
        select.selectByVisibleText(billingState);
        return this;
    }

    public CheckOutPage enterBillingPostalCode(String billingPostalCode){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingPostCodeFld));
        e.clear();
        e.sendKeys(billingPostalCode);
        return this;
    }

    public CheckOutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckOutPage setBillingDetails(String billingFirstName, String billingLastName,
                                          String billingAddressOne, String billingCity,
                                          String billingState, String billingPostalCode,
                                          String billingEmail){
        return enterBillingFirstName(billingFirstName).enterBillingLastName(billingLastName)
                .enterBillingAddressOne(billingAddressOne).enterBillingCityFld(billingCity)
                .enterBillingStateDropDown(billingState).enterBillingPostalCode(billingPostalCode)
                .enterBillingEmail(billingEmail);
    }

    public CheckOutPage placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeMessage)).getText();
    }

}







