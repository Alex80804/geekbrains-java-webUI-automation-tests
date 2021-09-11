package lesson8.WInthingsHealthmate;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WithingsHealthmateTemperaturePage {

    public static final String temperatureInputXpath = "//input[@class='temperatureInput']";
    private SelenideElement temperatureInput = $(By.xpath(temperatureInputXpath));

    public static final String temperatureSaveButtonXpath = "//span[text()='Сохранить']";
    private SelenideElement temperatureSaveButton = $(By.xpath(temperatureSaveButtonXpath));

    public static final String savedTemperaturesXpath = "//div[contains(text(), '°C')]";
    public List<SelenideElement> savedTemperatures = $$(By.xpath(savedTemperaturesXpath));

    @Step("Заполнение поля температура")
    public WithingsHealthmateTemperaturePage inputTemperature(String tempToAdd) {
        temperatureInput.sendKeys(tempToAdd);
        return this;
    }

    @Step("Клик на кнопку сохранить температуру")
    public void saveTemperature() {
        temperatureSaveButton.click();
    }
}
