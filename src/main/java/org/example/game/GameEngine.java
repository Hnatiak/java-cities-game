package org.example.game;

import java.util.*;

public class GameEngine {

    private final List<String> cities;
    private final Set<String> usedCities = new HashSet<>();

    private String lastComputerCity;

    private int score = 0;

    public GameEngine() {
        this.cities = new ArrayList<>(CityRepository.getCities());
    }

    public String makeMove(String playerCity) {

        playerCity = playerCity.trim();

        String normalizedPlayerCity = findCity(playerCity);

        if (normalizedPlayerCity == null) {
            throw new IllegalArgumentException(
                    "Такого міста не існує"
            );
        }

        if (usedCities.contains(normalizedPlayerCity)) {
            throw new IllegalArgumentException(
                    "Вказане місто вже було зазначене раніше"
            );
        }

        if (lastComputerCity != null) {

            char requiredLetter =
                    getLastValidLetter(lastComputerCity);

            if (Character.toLowerCase(
                    normalizedPlayerCity.charAt(0))
                    != requiredLetter) {

                throw new IllegalArgumentException(
                        "Місто повинно починатися на букву "
                                + Character.toUpperCase(requiredLetter)
                );
            }
        }

        usedCities.add(normalizedPlayerCity);

        score++;

        char lastLetter =
                getLastValidLetter(normalizedPlayerCity);

        for (String city : cities) {

            if (usedCities.contains(city)) {
                continue;
            }

            if (Character.toLowerCase(city.charAt(0))
                    == lastLetter) {

                usedCities.add(city);

                lastComputerCity = city;

                return city;
            }
        }

        return null;
    }

    public int getUsedCitiesCount() {
        return usedCities.size();
    }

    private String findCity(String cityName) {

        for (String city : cities) {

            if (city.equalsIgnoreCase(cityName)) {
                return city;
            }
        }

        return null;
    }

    private char getLastValidLetter(String city) {

        city = city.toLowerCase();

        for (int i = city.length() - 1; i >= 0; i--) {

            char ch = city.charAt(i);

            if (ch != 'ь'
                    && ch != 'й'
                    && ch != 'ъ'
                    && ch != 'ы'
                    && ch != 'и'
                    && ch != '-') {
                return ch;
            }
        }

        throw new IllegalArgumentException(
                "Некоректна назва міста"
        );
    }

    public int getScore() {
        return score;
    }
}