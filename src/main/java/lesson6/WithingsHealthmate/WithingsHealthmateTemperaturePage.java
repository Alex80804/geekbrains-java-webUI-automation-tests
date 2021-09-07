package lesson6.WithingsHealthmate;

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

    public WithingsHealthmateTemperaturePage inputTemperature(String tempToAdd) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(temperatureInputXpath)));
        temperatureInput.sendKeys(tempToAdd);
        return this;
    }

    public void saveTemperature() {
        temperatureSaveButton.click();
    }
}
