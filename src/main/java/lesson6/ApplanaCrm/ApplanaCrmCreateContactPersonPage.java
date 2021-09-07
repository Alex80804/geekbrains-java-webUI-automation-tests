package lesson6.ApplanaCrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApplanaCrmCreateContactPersonPage extends ApplanaCrmBasePage {
    public ApplanaCrmCreateContactPersonPage(WebDriver driver) {
        super(driver);
    }

    public static final String lastNameXpath = "//input[contains(@id, 'crm_contact_lastName')]";
    @FindBy(xpath = lastNameXpath)
    private WebElement lastNameInput;

    public static final String firstNameXpath = "//input[contains(@id, 'crm_contact_firstName')]";
    @FindBy(xpath = firstNameXpath)
    private WebElement firstNameInput;

    public static final String crmOrganizationSelectXpath = "//a[@class='select2-choice select2-default']";
    @FindBy(xpath = crmOrganizationSelectXpath)
    private WebElement crmOrganizationSelect;

    public static final String crmOrganizationInputXpath = "//div[@id='select2-drop']//input";
    @FindBy(xpath = crmOrganizationInputXpath)
    private WebElement crmOrganizationInput;

    public static final String crmOrganizationValueXpath = "//div[contains(text(), 'Organisation_1')]";
    @FindBy(xpath = crmOrganizationValueXpath)
    private WebElement crmOrganizationValue;

    public static final String jobTitleXpath = "//input[contains(@id, 'crm_contact_jobTitle')]";
    @FindBy(xpath = jobTitleXpath)
    private WebElement jobTitleInput;

    public static final String saveButtonXpath = "//button[contains(text(), 'Сохранить и закрыть')]";
    @FindBy(xpath = saveButtonXpath)
    private WebElement saveButton;

    public ApplanaCrmCreateContactPersonPage fillLastName(String lastName) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lastNameXpath)));
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public ApplanaCrmCreateContactPersonPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public ApplanaCrmCreateContactPersonPage clickCrmOrganizationSelect() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(crmOrganizationSelectXpath)));
        crmOrganizationSelect.click();
        return this;
    }

    public ApplanaCrmCreateContactPersonPage fillCrmOrganizationInput(String organizationPart) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(crmOrganizationInputXpath)));
        crmOrganizationInput.sendKeys(organizationPart);
        return this;
    }

    public ApplanaCrmCreateContactPersonPage chooseCrmOrganizationValue() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(crmOrganizationValueXpath)));
        crmOrganizationValue.click();
        return this;
    }

    public ApplanaCrmCreateContactPersonPage fillJobTitle(String jobTitle) {
        jobTitleInput.sendKeys(jobTitle);
        return this;
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
