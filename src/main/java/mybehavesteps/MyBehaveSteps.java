package mybehavesteps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.impl.bootstrap.HttpServer;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import service.Service;

import java.io.IOException;
import java.net.*;

public class MyBehaveSteps {

    private int actualStatusCode;

    public boolean statusCode(int expectedStatusCode) {
        System.out.println("Фактический статус код ответа: " + actualStatusCode);
        return actualStatusCode == expectedStatusCode;
    }

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

    @Step("Я запрашиваю текущую погоду в Лондоне на некорректном ресурсе.")
    public ValidatableResponse getCurrentLondonWeatherOnIncorrectURI() {
        return getSpec()
                .when()
                .get(Service.LONDON_NEGATIVE)
                .then().log().all();
    }

    @Step("Я запрашиваю текущую погоду в Москве.")
    public ValidatableResponse getCurrentMoscowWeather() {
        return getSpec()
                .when()
                .get(Service.MOSCOW)
                .then().log().all();
    }

    @Step("Я запрашиваю текущую погоду в Москве без токена.")
    public ValidatableResponse getCurrentMoscowWeatherWithoutToken() {
        return getSpec()
                .when()
                .get(Service.MOSCOW_NEGATIVE)
                .then().log().all();
    }

    @Step("Я запрашиваю текущую погоду в Риме.")
    public ValidatableResponse getCurrentRomeWeather() {
        return getSpec()
                .when()
                .get(Service.ROME)
                .then().log().all();
    }

    @Step("Я запрашиваю текущую погоду в Риме с некорректными данными.")
    public ValidatableResponse getCurrentRomeWeatherWithIncorrectData() {
        return getSpec()
                .when()
                .get(Service.ROME_NEGATIVE)
                .then().log().all();
    }

    @Step("Я запрашиваю текущую погоду в Нью-Йорке.")
    public ValidatableResponse getCurrentNewYorkWeather() {
        return getSpec()
                .when()
                .get(Service.NEW_YORK)
                .then().log().all();
    }

    @Step("Получаю необходимые данные из JSON по погоде в Лондоне.")
    public Double getDataLondonWeather() {
        String response = getSpec()
                .when()
                .get(Service.LONDON)
                .then()
                .log().all()
                .extract().response().asString();

        jsonParseMethod(response);
        return jsonParseMethod(response);
    }

    @Step("Получаю необходимые данные из JSON по погоде в Москве.")
    public Double getDataMoscowWeather() {
        String response = getSpec()
                .when()
                .get(Service.MOSCOW)
                .then()
                .log().all()
                .extract().response().asString();

        jsonParseMethod(response);
        return jsonParseMethod(response);
    }

    @Step("Получаю необходимые данные из JSON по погоде в Риме.")
    public Double getDataRomeWeather() {
        String response = getSpec()
                .when()
                .get(Service.ROME)
                .then()
                .log().all()
                .extract().response().asString();

        jsonParseMethod(response);
        return jsonParseMethod(response);
    }

    @Step("Получаю необходимые данные из JSON по погоде в Нью-Йорке.")
    public Double getDataNewYorkWeather() {
        String response = getSpec()
                .when()
                .get(Service.NEW_YORK)
                .then()
                .log().all()
                .extract().response().asString();

        jsonParseMethod(response);
        return jsonParseMethod(response);
    }

    @Step("Имитирую 301 ошибку.")
    public void imitation302() throws IOException {
        String url = "http://google.com";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setInstanceFollowRedirects(false); // отключаем автоматическое следование за редиректами
        int statusCode = connection.getResponseCode();

        if (statusCode == HttpURLConnection.HTTP_MOVED_PERM) {
            System.out.println("Статус код 301 успешно имитирован.");
        } else {
            System.out.println("Не удалось имитировать статус код 301.");
        }
    }

    private Double jsonParseMethod(String response) {
        JsonPath jsonPath = new JsonPath(response);
        String city = jsonPath.getString("location.name");
        Double temperature = jsonPath.getDouble("current.temp_c");

        if (city != null) {
            System.out.println("Город: " + city);
        } else {
            System.out.println("Информация о городе недоступна.");
        }

        if (temperature != null) {
            System.out.println("Температура: " + temperature);
        } else {
            System.out.println("Информация о температуре недоступна.");
        }
        return temperature;
    }
}