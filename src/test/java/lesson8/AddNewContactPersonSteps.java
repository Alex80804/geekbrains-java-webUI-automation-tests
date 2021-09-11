package lesson8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.ApplanaCrm.ApplanaCrmContactPersonListPage;
import lesson8.ApplanaCrm.ApplanaCrmCreateContactPersonPage;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddNewContactPersonSteps {
    @When("I go to contact persons list page")
    public void iGoToContactPersonsListPage() {
        open("https://crm.geekbrains.space/contact/");
    }

    @And("I click create contact person button")
    public void iClickCreateContactPersonButton() {
        new ApplanaCrmContactPersonListPage().clickCreateButton();
    }

    @And("I fill last name {string} and first name {string}")
    public void iFillLastNameLastNameAndFirstNameFirstName(String lastName, String firstName) {
        new ApplanaCrmCreateContactPersonPage().fillLastName(lastName).fillFirstName(firstName);
    }

    @And("I search organizations for contact person with {string} substring and choose one from the dropdown list")
    public void iSearchOrganizationsForContactPersonWithOrgStringSubstringAndChooseOneFromTheDropdownList(String orgString) {
        new ApplanaCrmCreateContactPersonPage().clickCrmOrganizationSelect().fillCrmOrganizationInput(orgString).chooseCrmOrganizationValue();
    }

    @And("I fill job title {string}")
    public void iFillJobTitleJobTitle(String jobTitle) {
        new ApplanaCrmCreateContactPersonPage().fillJobTitle(jobTitle);
    }

    @And("I click save contact person button")
    public void iClickSaveContactPersonButton() {
        new ApplanaCrmCreateContactPersonPage().clickSaveButton();
    }

    @Then("a success message contact person saved is shown")
    public void aSuccessMessageContactPersonSavedIsShown() {
        $(By.xpath("//div[text()='Контактное лицо сохранено']")).
                shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}
