package lesson6.WithingsHealthmate;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WithingsHealthmateTimelinePage extends WithingsHealthmateBasePage {
    public static final String userIconXpath = "//div[@class='user']";
    @FindBy(xpath = userIconXpath)
    private WebElement userIcon;

    public static final String logoutMenuItemXpath = "//li[@class='js-logout']";
    @FindBy(xpath = logoutMenuItemXpath)
    private WebElement logoutMenuItem;

    public static final String addMeasurementIconXpath = "//div[@class='addbutton menu']/div/span[@class='HMIcons_plus']";
    @FindBy(xpath = addMeasurementIconXpath)
    private WebElement addMeasurementIcon;

    public static final String addTemperatureIconXpath = "//li[@data-trigger='app:temperature:list:add']//span";
    @FindBy(xpath = addTemperatureIconXpath)
    private WebElement addTemperatureIcon;

    public static final String editHeatmapLayoutButtonXpath = "//span[@class='js-manage HMIcons_edit']";
    @FindBy(xpath = editHeatmapLayoutButtonXpath)
    private WebElement editHeatmapLayoutButton;

    public static final String setAsDefaultButtonXpath = "//div[@class='heatmap-daily']//div[@class=' val button uppercase js-default']";
    @FindBy(xpath = setAsDefaultButtonXpath)
    private WebElement setAsDefaultButton;

    public static final String heatmapSlideButtonXpath = "//div[@class='slide-button']";
    @FindBy(xpath = heatmapSlideButtonXpath)
    private WebElement heatmapSlideButton;

    public static final String sidePanelCloseButtonXpath = "//div[@class='HMIcons_close action js-close']";
    @FindBy(xpath = sidePanelCloseButtonXpath)
    private WebElement sidePanelCloseButton;


    public WithingsHealthmateTimelinePage(WebDriver driver) {
        super(driver);
        driver.get("https://healthmate.withings.com/timeline");
    }

    @Step("Клик на иконку пользователя")
    public WithingsHealthmateTimelinePage clickUserIcon() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(userIconXpath)));
        userIcon.click();
        return this;
    }

    @Step("Клик на пункт меню logout")
    public void clickLogoutMenuItem() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(logoutMenuItemXpath)));
        logoutMenuItem.click();
    }

    @Step("Клик на кнопку добавить измерение")
    public WithingsHealthmateTimelinePage clickAddMeasurementIcon() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addMeasurementIconXpath)));
        addMeasurementIcon.click();
        return this;
    }

    @Step("Клик на пункт меню добавить температуру")
    public WithingsHealthmateTemperaturePage clickAddTemperatureIcon() {
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(addTemperatureIconXpath))));
        addTemperatureIcon.click();
        return new WithingsHealthmateTemperaturePage(driver);
    }

    @Step("Клик на кнопку изменения типа heatmap")
    public WithingsHealthmateTimelinePage clickHeatmapLayoutButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(editHeatmapLayoutButtonXpath)));
        editHeatmapLayoutButton.click();
        return this;
    }

    @Step("Клик на кнопку установки стиля по умолчанию")
    public WithingsHealthmateTimelinePage clickSetAsDefaultButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(setAsDefaultButtonXpath)));
        setAsDefaultButton.click();
        return this;
    }

    @Step("Двойной клик на слайдер переключения активности heatmap")
    public WithingsHealthmateTimelinePage clickHeatmapSlideButtonTwice() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(heatmapSlideButtonXpath)));
        heatmapSlideButton.click();
        heatmapSlideButton.click();
        return this;
    }

    @Step("Клик на кнопку закрытия боковой панели")
    public void clickSidePanelCloseButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sidePanelCloseButtonXpath)));
        sidePanelCloseButton.click();
    }
}
