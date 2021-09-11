package lesson6.WithingsHealthmate;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WithingsHealthmateTemperaturePage extends WithingsHealthmateBasePage {
    public WithingsHealthmateTemperaturePage(WebDriver driver) {
        super(driver);
    }

    public static final String temperatureInputXpath = "//input[@class='temperatureInput']";
    @FindBy(xpath = temperatureInputXpath)
    private WebElement temperatureInput;

    public static final String temperatureSaveButtonXpath = "//span[text()='Сохранить']";
    @FindBy(xpath = temperatureSaveButtonXpath)
    private WebElement temperatureSaveButton;

    @Step("Заполнение поля температура")
    public WithingsHealthmateTemperaturePage inputTemperature(String tempToAdd) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(temperatureInputXpath)));
        temperatureInput.sendKeys(tempToAdd);
        return this;
    }

    @Step("Клик на кнопку сохранить температуру")
    public void saveTemperature() {
        temperatureSaveButton.click();
    }
}
