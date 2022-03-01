package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    @FindBy(id= "group_1")
    private WebElement sizeDropDownField;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityField;

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void sizeInput(String size){
//        sizeDropDownField.click();
        sizeDropDownField.sendKeys(size);
        sizeDropDownField.click();
    }
    public void quantityInput(String quantity){
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(quantity);
        quantityField.click();
    }
    public void clickAddToCartButton(){
        if(addToCartButton.isEnabled())
            addToCartButton.click();
        else
            Assert.fail();

        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
    }

}
