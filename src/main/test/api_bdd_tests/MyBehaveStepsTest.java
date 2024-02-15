package api_bdd_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import mybehavesteps.MyBehaveSteps;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.Test;
import service.Service;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

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

    @Test
    @DisplayName("Тест на проверку получения необходимых температурных данных погоды в Лондоне.")
    @Description("Проверка сравнения ожидаемого результата с актуальным с учётом дельты.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getWeatherTemperatureLondon() {
        step = new MyBehaveSteps();
        Double actualTemperature = step.getDataLondonWeather();
        if (Math.abs(Service.expectedTemperatureLondon - actualTemperature) <= Service.deltaLondon) {
            Service.LOGGER.info(Service.GREEN + "Температура соответствует ожидаемой. Ожидаемая температура: " + Service.
                    RESET + Service.expectedTemperatureLondon + Service.GREEN + " Текущая температура: " + Service.
                    RESET + actualTemperature + Service.GREEN + " Дельта при этом равна: " + Service.RESET + Service.deltaLondon);
        }
        assertEquals(Service.BLUE + "Температура не соответствует ожидаемой. " + Service.
                RESET, Service.expectedTemperatureLondon, actualTemperature, Service.deltaLondon);
    }

    @Test
    @DisplayName("Тест на проверку получения необходимых температурных данных погоды в Москве.")
    @Description("Проверка сравнения ожидаемого результата с актуальным с учётом дельты.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getWeatherTemperatureMoscow() {
        step = new MyBehaveSteps();
        Double actualTemperature = step.getDataMoscowWeather();
        if (Math.abs(Service.expectedTemperatureMoscow - actualTemperature) <= Service.deltaMoscow) {
            Service.LOGGER.info(Service.GREEN + "Температура соответствует ожидаемой. Ожидаемая температура: " + Service.
                    RESET + Service.expectedTemperatureMoscow + Service.GREEN + " Текущая температура: " + Service.
                    RESET + actualTemperature + Service.GREEN + " Дельта при этом равна: " + Service.RESET + Service.deltaMoscow);
        }
        assertEquals(Service.BLUE + "Температура не соответствует ожидаемой. " + Service.
                RESET, Service.expectedTemperatureMoscow, actualTemperature, Service.deltaMoscow);
    }

    @Test
    @DisplayName("Тест на проверку получения необходимых температурных данных погоды в Риме.")
    @Description("Проверка сравнения ожидаемого результата с актуальным с учётом дельты.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getWeatherTemperatureRome() {
        step = new MyBehaveSteps();
        Double actualTemperature = step.getDataRomeWeather();
        if (Math.abs(Service.expectedTemperatureRome - actualTemperature) <= Service.deltaRome) {
            Service.LOGGER.info(Service.GREEN + "Температура соответствует ожидаемой. Ожидаемая температура: " + Service.
                    RESET + Service.expectedTemperatureRome + Service.GREEN + " Текущая температура: " + Service.
                    RESET + actualTemperature + Service.GREEN + " Дельта при этом равна: " + Service.RESET + Service.deltaRome);
        }
        assertEquals(Service.BLUE + "Температура не соответствует ожидаемой. " + Service.
                RESET, Service.expectedTemperatureRome, actualTemperature, Service.deltaRome);
    }

    @Test
    @DisplayName("Тест на проверку получения необходимых температурных данных погоды в Нью-Йорк.")
    @Description("Проверка сравнения ожидаемого результата с актуальным с учётом дельты.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getWeatherTemperatureNewYork() {
        step = new MyBehaveSteps();
        Double actualTemperature = step.getDataNewYorkWeather();
        if (Math.abs(Service.expectedTemperatureNewYork - actualTemperature) <= Service.deltaNewYork) {
            Service.LOGGER.info(Service.GREEN + "Температура соответствует ожидаемой. Ожидаемая температура: " + Service.
                    RESET + Service.expectedTemperatureNewYork + Service.GREEN + " Текущая температура: " + Service.
                    RESET + actualTemperature + Service.GREEN + " Дельта при этом равна: " + Service.RESET + Service.deltaNewYork);
        }
        assertEquals(Service.BLUE + "Температура не соответствует ожидаемой. " + Service.
                RESET, Service.expectedTemperatureNewYork, actualTemperature, Service.deltaNewYork);
    }

    // Негативные тесты.
    @Test
    @DisplayName("Тест на проверку запроса погоды в Москве без токена.")
    @Description("Проверка корректности работы метода GET и получения ожидаемого статус-кода: 403 Forbidden.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getMoscowWeatherWithoutToken() {
        step = new MyBehaveSteps();
        ValidatableResponse responseCreate = step.getCurrentMoscowWeatherWithoutToken();
        responseCreate.assertThat().statusCode(HttpStatus.SC_FORBIDDEN);
    }

    @Test
    @DisplayName("Тест на проверку запроса погоды в Лондоне если запрашиваемый ресурс не найден.")
    @Description("Проверка корректности работы метода GET и получения ожидаемого статус-кода: 404 Not Found.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getLondonWeather404() {
        step = new MyBehaveSteps();
        ValidatableResponse responseCreate = step.getCurrentLondonWeatherOnIncorrectURI();
        responseCreate.assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    @DisplayName("Тест на проверку запроса погоды в Риме если переданы некорректные данные.")
    @Description("Проверка корректности работы метода GET и получения ожидаемого статус-кода: 400 Bad Request.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getRomeWeather400() {
        step = new MyBehaveSteps();
        ValidatableResponse responseCreate = step.getCurrentRomeWeatherWithIncorrectData();
        responseCreate.assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @DisplayName("Тест на проверку работоспособности запроса погоды в Нью-Йорке для симуляции ошибки 301.")
    @Description("Проверка корректности работы метода GET и получения ожидаемого статус-кода: 301.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("ссылка на таск")
    public void getNewYorkWeather500() throws IOException {
        MyBehaveSteps step = new MyBehaveSteps();
        step.imitation302();
        assertFalse(step.statusCode(HttpStatus.SC_MOVED_PERMANENTLY));
    }
}