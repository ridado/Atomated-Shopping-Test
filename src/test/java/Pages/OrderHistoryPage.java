package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr/td[2]")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr/td[4]/span")
    WebElement orderStatus;

    public OrderHistoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String checkTotalPrice(){
        return totalPrice.getText();
    }

    public String checkOrderStaus(){
        return orderStatus.getText();
    }
}
