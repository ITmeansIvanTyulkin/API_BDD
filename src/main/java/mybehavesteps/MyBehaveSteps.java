package mybehavesteps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import service.Service;

public class MyBehaveSteps {


    @Given("I am going to request the weather temperature in a specific city")
    public void givenIRequestWeatherTemperature() {
        // Действия для данного шага
    }

    @When("I request current weather in London")
    public void whenIRequestWeatherInLondon() {
        getCurrentLondonWeather();
    }

    @Then("I should receive a successful response")
    public void thenIShouldReceiveSuccessfulResponse() {
        // Действия для данного шага
    }


    @Step("Создание спецификации, общее для всех steps.")
    public static RequestSpecification getSpec() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(Service.BASE_URI);
    }

    @Step("Я запрашиваю текущую погоду в Лондоне.")
    public ValidatableResponse getCurrentLondonWeather() {
        return getSpec()
                .when()
                .get(Service.LONDON)
                .then().log().all();
    }

    @Step("Я запрашиваю текущую погоду в Москве.")
    public ValidatableResponse getCurrentMoscowWeather() {
        return getSpec()
                .when()
                .get(Service.MOSCOW)
                .then().log().all();
    }

    @Step("Я запрашиваю текущую погоду в Риме.")
    public ValidatableResponse getCurrentRomeWeather() {
        return getSpec()
                .when()
                .get(Service.ROME)
                .then().log().all();
    }

    @Step("Я запрашиваю текущую погоду в Нью-Йорке.")
    public ValidatableResponse getCurrentNewYorkWeather() {
        return getSpec()
                .when()
                .get(Service.NEW_YORK)
                .then().log().all();
    }



    // методы распарсивания JSON


}