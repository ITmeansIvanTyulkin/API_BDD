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
    String currentWeather = "/current.json";
    String key = "?key=";

    String queryParameter = "&q=";
    String valueMoscow = "Moscow";
    String valueLondon = "London";
    String valueNewYork = "New York";
    String valueRome = "Rome";

    String LONDON = BASE_URI + currentWeather + key + token + queryParameter + valueLondon;
    String MOSCOW = BASE_URI + currentWeather + key + token + queryParameter + valueMoscow;
    String NEW_YORK = BASE_URI + currentWeather + key + token + queryParameter + valueNewYork;
    String ROME = BASE_URI + currentWeather + key + token + queryParameter + valueRome;

    // Эталонные значения для Лондона.
    String expectedCityLondon = "London";
    double expectedTemperatureLondon = 12.0;
    double deltaLondon = 1.0; // Дельта для сравнения температуры

    // Эталонные значения для Москвы.
    String expectedCityMoscow = "London";
    double expectedTemperatureMoscow = -9.0;
    double deltaMoscow = 1.0;






}