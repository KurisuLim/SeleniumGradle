package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //Method to stop the using sleeps
    public void waitVisibility(By element){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public void waitFoClick(By element){
        waitVisibility(element);
        driver.findElement(element).click();
    }

    public void setText(By element, String text){
        waitVisibility(element);
        driver.findElement(element).sendKeys(text);
    }

    public String getText(By element){
        waitVisibility(element);
        return  driver.findElement(element).getText();
    }

    public void assertEquals(By element, String expectText){
        waitVisibility(element);
        Assert.assertEquals(getText(element), expectText);
    }

}
