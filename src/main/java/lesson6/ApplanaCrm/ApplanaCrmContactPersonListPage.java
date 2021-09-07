package lesson6.ApplanaCrm;

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

    public ApplanaCrmCreateContactPersonPage clickCreateButton() {
        createContactPersonButton.click();
        return new ApplanaCrmCreateContactPersonPage(driver);
    }
}
