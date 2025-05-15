package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class FelineParameterTest {

    @ParameterizedTest
    @ValueSource(strings = {"Хищник"})
    void testEatMeatParametrized(String animalType) throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood, "Рацион питания неверный для типа животного: " + animalType);
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3, 10})
    void testGetKittens(int input) {
        Feline feline = new Feline();
        int result = feline.getKittens(input);
        assertEquals(input, result, "Неверное число детенышей.");
    }


}
