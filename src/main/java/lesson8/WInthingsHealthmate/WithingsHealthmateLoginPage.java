package lesson8.WInthingsHealthmate;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WithingsHealthmateLoginPage {
    private SelenideElement cookieButtonOK = $(By.xpath("//button[@class='accept-selection']"));

    private SelenideElement email = $(By.name("email"));

    private SelenideElement password = $(By.name("password"));

    private SelenideElement loginButton = $(By.xpath("//button[text()='Вход']"));

    @Step("Переход на начальную страницу - закрытие окна cookie")
    public WithingsHealthmateLoginPage clickCookieOK() {
        try {
            cookieButtonOK.click();
        } catch (NoSuchElementException e){

        }
        finally {
            return page(WithingsHealthmateLoginPage.class);
        }
    }

    @Step("Заполнение поля email")
    public WithingsHealthmateLoginPage fillEmail(String loginEmail) {
        email.sendKeys(loginEmail);
        return page(WithingsHealthmateLoginPage.class);
    }

    @Step("Заполнение поля пароль")
    public WithingsHealthmateLoginPage fillPassword(String loginPassword) {
        password.sendKeys(loginPassword);
        return page(WithingsHealthmateLoginPage.class);
    }

    @Step("Клик на кнопку \"Войти\"")
    public void clickLoginButton() {
        loginButton.click();
    }
}
