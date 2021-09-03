package lesson6.WithingsHealthmate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithingsHealthmateLoginPage extends WithingsHealthmateBasePage {
    @FindBy(xpath = "//button[@class='accept-selection']")
    private WebElement cookieButtonOK;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Вход']")
    private WebElement loginButton;

    public WithingsHealthmateLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://account.withings.com/connectionwou/account_login?r=https://healthmate.withings.com/");
    }

    public WithingsHealthmateLoginPage clickCookieOK() {
        cookieButtonOK.click();
        return this;
    }

    public WithingsHealthmateLoginPage fillEmail(String loginEmail) {
        email.sendKeys(loginEmail);
        return this;
    }

    public WithingsHealthmateLoginPage fillPassword(String loginPassword) {
        password.sendKeys(loginPassword);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
