package lesson6.WithingsHealthmate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithingsHealthmateBasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public WithingsHealthmateBasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }
}
