package lesson6.ApplanaCrm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplanaCrmContactPersonListPage extends ApplanaCrmBasePage{
    public ApplanaCrmContactPersonListPage(WebDriver driver) {
        super(driver);
        driver.get("https://crm.geekbrains.space/contact/");
    }

    @FindBy(xpath = "//a[text()='Создать контактное лицо']")
    private WebElement createContactPersonButton;

    @Step("Нажатие на кнопку создать")
    public ApplanaCrmCreateContactPersonPage clickCreateButton() {
        createContactPersonButton.click();
        return new ApplanaCrmCreateContactPersonPage(driver);
    }
}
