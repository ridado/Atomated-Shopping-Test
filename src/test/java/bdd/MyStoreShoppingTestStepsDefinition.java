package bdd;

import Pages.LoginPage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import Pages.StartPage;
import helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;

public class MyStoreShoppingTestStepsDefinition {
    private WebDriver driver;

    @Given("User is on shop main page")
    public void userIsOnShopMainPage() {
        driver = WebDriverFactory.createChromedriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

    }

    @When("user log in to account and go back to main page")
    public void userLogInToAccountAndGoBackToMainPage() {

        String email = "krystyna.malina@mail.com";
        String password = "asd12345";

        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        startPage.clickToSignIn();
        loginPage.userLogIn(email, password);
    }

    @When("user choose item and clicks for details")
    public void userChooseItemAndClicksForDetails() {
        StartPage startPage = new StartPage(driver);

        String itemName = "Hummingbird printed sweater";
        String discountPercentage = "20";

//        Assertions.assertEquals(discountPercentage, startPage.isDiscount());
        startPage.itemChoose(itemName);

    }

    @When("user checks is discount actual choose size and quantity")
    public void userChecksIsDiscountActualChooseSizeAndQuantity() {
        ProductPage productPage = new ProductPage(driver);

        String itemSize = "l";
        String itemQuantity = "5"; // sprawdzi dostępność

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
//        driver.get("http://www.google.com/");
//        TakesScreenshot scrFile = (TakesScreenshot)driver;
//        File source = scrFile.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(source, new File("./files/screenshot.png"));
    }

    @Then("user go to account order history and checks amount and status")
    public void userGoToAccountOrderHistoryAndChecksAmountAndStatus() {
    }

    @Then("shut down browser")
    public void shutDownBrowser() {
//        driver.quit();
    }
}
