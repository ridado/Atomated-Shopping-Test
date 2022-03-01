package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
    private WebElement addressContinueButton;

    @FindBy(xpath = "//*[@id=\"delivery_option_1\"]")
    private WebElement shippingMethodPrestaShop;

    @FindBy(xpath = "//*[@id=\"delivery_option_2\"]")
    private WebElement shippingMethodMyCarrier;

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    private WebElement shippingMethodContinueButton;

    @FindBy(xpath = "//*[@id=\"payment-option-1-container\"]/span")
    private WebElement payByCheckbutton;

    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement iAgreeToTermsButton;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement orderWithObligationToPayButton;


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToChceckout() {
        proceedToCheckoutButton.click();
    }

    public void addressConfirmbutton() {
        addressContinueButton.click();
    }

    public void shoppingMethodChoose() {
        if (shippingMethodPrestaShop.isSelected())
            shippingMethodContinueButton.click();
        else {
            shippingMethodPrestaShop.click();
            shippingMethodContinueButton.click();
        }
    }
    public void paymentMethodChoose(){
        payByCheckbutton.click();
        iAgreeToTermsButton.click();

    }
    public void confirmOrderWithObligationToPay(){
        orderWithObligationToPayButton.click();
    }
}
