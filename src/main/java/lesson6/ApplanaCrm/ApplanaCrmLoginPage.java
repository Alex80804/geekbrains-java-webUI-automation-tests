package lesson6.ApplanaCrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplanaCrmLoginPage extends ApplanaCrmBasePage{
    public ApplanaCrmLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://crm.geekbrains.space/user/login");
    }

    @FindBy(id = "prependedInput")
    private WebElement loginInput;

    @FindBy(id = "prependedInput2")
    private WebElement passwordInput;

    @FindBy(id = "_submit")
    private WebElement loginButton;

    public ApplanaCrmLoginPage fillLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public ApplanaCrmLoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
