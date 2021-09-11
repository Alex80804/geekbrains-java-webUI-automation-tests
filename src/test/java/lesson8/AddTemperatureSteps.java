package lesson8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import lesson8.WInthingsHealthmate.WithingsHealthmateTemperaturePage;
import lesson8.WInthingsHealthmate.WithingsHealthmateTimelinePage;

public class AddTemperatureSteps {
    @When("I click add button")
    public void iClickAddButton() {
        new WithingsHealthmateTimelinePage().clickAddMeasurementIcon();
    }

    @And("I click temperature item")
    public void iClickTemperatureItem() {
        new WithingsHealthmateTimelinePage().clickAddTemperatureIcon();
    }

    @And("I fill {string} field")
    public void iFillTemperatureField(String temperature) {
        new WithingsHealthmateTemperaturePage().inputTemperature(temperature);
    }

    @And("I click save button")
    public void iClickSaveButton() {
        new WithingsHealthmateTemperaturePage().saveTemperature();
    }

    @Then("The last temperature measure is shown")
    public void theLastTemperatureMeasureIsShown() {
        new WithingsHealthmateTemperaturePage().savedTemperatures.get(0).shouldBe(Condition.visible).getText().equals("36.4 °C");
/*
        $(By.xpath("//div[contains(text(), '°C')]")).shouldBe(Condition.visible, Duration.ofSeconds(30));
        List<SelenideElement> temps = $$(By.xpath("//div[contains(text(), '°C')]"));
        CustomEventListener.logger.info("TEMP - " + temps.get(0).getText());
        Assertions.assertEquals( "36.4 °C", temps.get(0).getText());
 */
    }


}
