import Pages.LoginPage;
import Pages.StartPage;
import helpers.WebDriverFactory;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class shoppingTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createChromedriverWithImplicitlyWait(10);

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//        System.out.println("Test zakończony");}

    @Test
    public void clickToSignIn() {

        // arrange
        String email = "krystyna.malina@mail.com";
        String password = "asd12345";
        LoginPage loginPage = new LoginPage(driver);

        // act

        loginPage.userLogIn(email, password);
    }
    @Test
    public void clickToChooseItem(){

        //arrange
        String itemName = "Hummingbird printed sweater";
        String discountPercentage = "20";

        StartPage startPage = new StartPage(driver);

        //act
        startPage.itemChoose(itemName);
        Assertions.assertEquals(discountPercentage, startPage.isDiscount());



    }
}
