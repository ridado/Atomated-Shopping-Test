package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"history-link\"]/span")
    private WebElement orderHistory;

    public YourAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToOrderHistory(){
        orderHistory.click();
    }
}
