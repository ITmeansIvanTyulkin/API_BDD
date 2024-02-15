package service;

import java.util.logging.Logger;

public interface Service {

    String GREEN = "\u001B[32m";
    String BLUE = "\u001B[34m";
    String RESET = "\u001B[0m";

    Logger LOGGER = Logger.getLogger(Service.class.getName());
    static void LOGGER(String s) {
    }

    String token = "5cbe8f57fb39402e9ed160916241202";

    // Ручки.
    final String BASE_URI = "http://api.weatherapi.com/v1";
    final String WRONG_BASE_URI = "http://api.weatherapi.com/";
    String currentWeather = "/current.json";
    String key = "?key=";

    String queryParameter = "&q=";
    String queryParameterNegative = "&p=";
    String valueLondon = "London";
    String valueMoscow = "Moscow";
    String valueNewYork = "New York";
    String valueRome = "Rome";

    String LONDON = BASE_URI + currentWeather + key + token + queryParameter + valueLondon;
    String MOSCOW = BASE_URI + currentWeather + key + token + queryParameter + valueMoscow;
    String NEW_YORK = BASE_URI + currentWeather + key + token + queryParameter + valueNewYork;
    String ROME = BASE_URI + currentWeather + key + token + queryParameter + valueRome;

    // Для негативных тестов.
    String MOSCOW_NEGATIVE = BASE_URI + currentWeather + key + queryParameter + valueMoscow;
    String LONDON_NEGATIVE = WRONG_BASE_URI + currentWeather + key + token + queryParameter + valueLondon;
    String ROME_NEGATIVE = BASE_URI + currentWeather + key + token + queryParameterNegative + valueRome;

    // Эталонные значения для Лондона.
    String expectedCityLondon = "London";
    double expectedTemperatureLondon = 12.0;
    double deltaLondon = 10.0; // Дельта для сравнения температуры

    // Эталонные значения для Москвы.
    String expectedCityMoscow = "London";
    double expectedTemperatureMoscow = -9.0;
    double deltaMoscow = 10.0;

    // Эталонные значения для Нью-Йорка.
    String expectedCityNewYork = "New York";
    double expectedTemperatureNewYork = -1.0;
    double deltaNewYork = 10.0;

    // Эталонные значения для Рима.
    String expectedCityRome = "Rome";
    double expectedTemperatureRome = 11.0;
    double deltaRome = 10.0;
}