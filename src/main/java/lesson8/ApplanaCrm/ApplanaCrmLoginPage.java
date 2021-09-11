package lesson8.ApplanaCrm;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class ApplanaCrmLoginPage {

    private SelenideElement loginInput = $(By.id("prependedInput"));

    private SelenideElement passwordInput = $(By.id("prependedInput2"));

    private SelenideElement loginButton = $(By.id("_submit"));

    @Step("Заполнение логина")
    public ApplanaCrmLoginPage fillLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Заполнение пароля")
    public ApplanaCrmLoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку логина")
    public void clickLoginButton() {
        loginButton.click();
    }
}
