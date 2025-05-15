package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;


class CatParameterTest {

    private Feline felineMock;
    private Cat cat;

    @BeforeEach
    void setup() {
        felineMock = Mockito.mock(Feline.class);
        cat = new Cat(felineMock);
    }

    // Параметризированный тест звуков
    @ParameterizedTest
    @ValueSource(strings = {"домашняя кошка", "домашний кот"})
    void testGetSound(String type) {
        assertEquals("Мяу", cat.getSound(), "Проверка звука [" + type + "]");
    }

    // Параметризированный тест рациона питания
    @ParameterizedTest
    @ValueSource(strings = {"растительный", "животный", "всеядный"})
    void testGetFood(String dietType) throws Exception {
        List<String> expectedFood;
        switch (dietType) {
            case "растительный":
                expectedFood = Arrays.asList("овощи", "фрукты");
                break;
            case "животный":
                expectedFood = Arrays.asList("животные", "птицы", "рыбы");
                break;
            default:
                expectedFood = Arrays.asList("разнообразный рацион");
        }

        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood, "Проверка диеты типа [" + dietType + "]");
    }
}
