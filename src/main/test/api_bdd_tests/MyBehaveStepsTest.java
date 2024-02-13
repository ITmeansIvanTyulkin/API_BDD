package api_bdd_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import mybehavesteps.MyBehaveSteps;
import org.apache.hc.core5.http.HttpStatus;
import org.jbehave.core.annotations.Given;
import org.junit.Test;

public class MyBehaveStepsTest {
    private MyBehaveSteps step;

    @Test
    @DisplayName("Тест на проверку работоспособности запроса погоды в Лондоне.")
    @Description("Проверка корректности работы метода GET и получения данных в формате JSON.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getLondonWeather() {
        step = new MyBehaveSteps();
        ValidatableResponse responseCreate = step.getCurrentLondonWeather();
        responseCreate.assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("Тест на проверку работоспособности запроса погоды в Москве.")
    @Description("Проверка корректности работы метода GET и получения данных в формате JSON.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getMoscowWeather() {
        step = new MyBehaveSteps();
        ValidatableResponse responseCreate = step.getCurrentMoscowWeather();
        responseCreate.assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("Тест на проверку работоспособности запроса погоды в Риме.")
    @Description("Проверка корректности работы метода GET и получения данных в формате JSON.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getRomeWeather() {
        step = new MyBehaveSteps();
        ValidatableResponse responseCreate = step.getCurrentRomeWeather();
        responseCreate.assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("Тест на проверку работоспособности запроса погоды в Нью-Йорке.")
    @Description("Проверка корректности работы метода GET и получения данных в формате JSON.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getNewYorkWeather() {
        step = new MyBehaveSteps();
        ValidatableResponse responseCreate = step.getCurrentNewYorkWeather();
        responseCreate.assertThat().statusCode(HttpStatus.SC_OK);
    }






}