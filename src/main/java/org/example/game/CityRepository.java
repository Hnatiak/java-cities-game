package org.example.game;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CityRepository {

    private CityRepository() {
    }

    public static List<String> getCities() {

        InputStream stream =
                CityRepository.class.getResourceAsStream(
                        "/cities.txt"
                );

        if (stream == null) {
            throw new RuntimeException(
                    "Файл cities.txt не знайдено"
            );
        }

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(stream)
                );

        return reader.lines().toList();
    }
}