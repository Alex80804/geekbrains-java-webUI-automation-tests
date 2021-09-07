package lesson6.ApplanaCrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplanaCrmBasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public ApplanaCrmBasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }
}
