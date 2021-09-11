package lesson8.WInthingsHealthmate;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class WithingsHealthmateTimelinePage {
    public static final String userIconXpath = "//div[@class='user']";
    private SelenideElement userIcon = $(By.xpath(userIconXpath));

    public static final String logoutMenuItemXpath = "//li[@class='js-logout']";
    private SelenideElement logoutMenuItem = $(By.xpath(logoutMenuItemXpath));

    public static final String addMeasurementIconXpath = "//div[@class='addbutton menu']/div/span[@class='HMIcons_plus']";
    private SelenideElement addMeasurementIcon = $(By.xpath(addMeasurementIconXpath));

    public static final String addTemperatureIconXpath = "//li[@data-trigger='app:temperature:list:add']//span";
    private SelenideElement addTemperatureIcon = $(By.xpath(addTemperatureIconXpath));

    public static final String editHeatmapLayoutButtonXpath = "//span[@class='js-manage HMIcons_edit']";
    private SelenideElement editHeatmapLayoutButton = $(By.xpath(editHeatmapLayoutButtonXpath));

    public static final String setAsDefaultButtonXpath = "//div[@class='heatmap-daily']//div[@class=' val button uppercase js-default']";
    private SelenideElement setAsDefaultButton = $(By.xpath(setAsDefaultButtonXpath));

    public static final String heatmapSlideButtonXpath = "//div[@class='slide-button']";
    private SelenideElement heatmapSlideButton = $(By.xpath(heatmapSlideButtonXpath));

    public static final String sidePanelCloseButtonXpath = "//div[@class='HMIcons_close action js-close']";
    private SelenideElement sidePanelCloseButton = $(By.xpath(sidePanelCloseButtonXpath));


    @Step("Клик на иконку пользователя")
    public WithingsHealthmateTimelinePage clickUserIcon() {
        userIcon.click();
        return this;
    }

    @Step("Клик на пункт меню logout")
    public void clickLogoutMenuItem() {
        logoutMenuItem.click();
    }

    @Step("Клик на кнопку добавить измерение")
    public WithingsHealthmateTimelinePage clickAddMeasurementIcon() {
        addMeasurementIcon.shouldBe(Condition.enabled, Duration.ofSeconds(20)).click();
        return this;
    }

    @Step("Клик на пункт меню добавить температуру")
    public WithingsHealthmateTemperaturePage clickAddTemperatureIcon() {
        addTemperatureIcon.shouldBe(Condition.visible, Duration.ofSeconds(20)).click();
        return page(WithingsHealthmateTemperaturePage.class);
    }

    @Step("Клик на кнопку изменения типа heatmap")
    public WithingsHealthmateTimelinePage clickHeatmapLayoutButton() {
        editHeatmapLayoutButton.click();
        return this;
    }

    @Step("Клик на кнопку установки стиля по умолчанию")
    public WithingsHealthmateTimelinePage clickSetAsDefaultButton() {
        setAsDefaultButton.click();
        return this;
    }

    @Step("Двойной клик на слайдер переключения активности heatmap")
    public WithingsHealthmateTimelinePage clickHeatmapSlideButtonTwice() {
        heatmapSlideButton.click();
        heatmapSlideButton.click();
        return this;
    }

    @Step("Клик на кнопку закрытия боковой панели")
    public void clickSidePanelCloseButton() {
        sidePanelCloseButton.click();
    }
}
