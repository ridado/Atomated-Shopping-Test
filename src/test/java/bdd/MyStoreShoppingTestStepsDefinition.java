package bdd;

import Pages.*;
import helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import java.io.File;

public class MyStoreShoppingTestStepsDefinition {
    private WebDriver driver;

    String orderAmount;

    @Given("User is on shop main page")
    public void userIsOnShopMainPage() {
        driver = WebDriverFactory.createChromedriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

    }

    @When("user log in to account and go back to main page")
    public void userLogInToAccountAndGoBackToMainPage() {

        String email = "bolek.lolek@mail.com";
        String password = "Super123";

        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        startPage.clickToSignIn();
        loginPage.userLogIn(email, password);
    }

    @When("user choose item and clicks for details")
    public void userChooseItemAndClicksForDetails() {
        StartPage startPage = new StartPage(driver);

        String itemName = "Hummingbird printed sweater";
        startPage.itemChoose(itemName);
    }

    @When("user checks is discount actual choose size and quantity")
    public void userChecksIsDiscountActualChooseSizeAndQuantity() {
        ProductPage productPage = new ProductPage(driver);

        String itemSize = "s";
        String itemQuantity = "5";// sprawdzi dostępność
        String discount = "SAVE 20%";

        Assertions.assertEquals(discount, productPage.isDiscountCorrect());

        productPage.sizeInput(itemSize);
        productPage.quantityInput(itemQuantity);
    }

    @And("clicks on add to cart button and proceed to checkout button")
    public void clicksOnAddToCartButtonAndProceedToCheckoutButton() {
        ProductPage productPage = new ProductPage(driver);
// sprawdzenie czy przycisk jest aktywny
        productPage.clickAddToCartButton();
    }

    @When("In shopping cart user confirm address, shipping method")
    public void inShoppingCartUserConfirmAddressShippingMethod() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        shoppingCartPage.clickProceedToChceckout();
        shoppingCartPage.addressConfirmbutton();
        shoppingCartPage.shoppingMethodChoose();
    }

    @And("choose payment method, agree with terms and conditions")
    public void choosePaymentMethodAgreeWithTermsAndConditions() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        shoppingCartPage.paymentMethodChoose();
    }

    @And("clicks order with obligation to pay button")
    public void clicksOrderWithObligationToPayButton() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        shoppingCartPage.confirmOrderWithObligationToPay();
    }

    @Then("user takes screenshot of order confirmation")
    public void userTakesScreenshotOfOrderConfirmation() throws Exception {
        OrderConfirmedPage orderConfirmedPage = new OrderConfirmedPage(driver);

        TakesScreenshot scrFile = (TakesScreenshot)driver;
        File source = scrFile.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./src/files/screenshot.png"));
        orderAmount = orderConfirmedPage.getOrderAmount();

    }

    @Then("user go to account order history and checks amount and status")
    public void userGoToAccountOrderHistoryAndChecksAmountAndStatus() {
        OrderConfirmedPage orderConfirmedPage = new OrderConfirmedPage(driver);
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);

        orderConfirmedPage.goToUserAccount();
        yourAccountPage.goToOrderHistory();
        Assertions.assertEquals(orderAmount, orderHistoryPage.checkTotalPrice());

    }

    @Then("shut down browser")
    public void shutDownBrowser() {
        driver.quit();
    }
}
