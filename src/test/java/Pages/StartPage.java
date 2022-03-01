package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/article[1]/div/div[1]/h3")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/article[2]/div/div[1]/div/span[3]")
    private WebElement discountField;

    public StartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickToSignIn(){
        signInButton.click();
    }
    public void itemChoose(String name){
        productTitle.click();
    }
    public String isDiscount(){
       return discountField.getText();
    }
    
}
