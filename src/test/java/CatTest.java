package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

class CatTest {

    // Проверка конструктора
    @Test
    void testConstructor() {
        Feline felineMock = Mockito.mock(Feline.class);
        Cat cat = new Cat(felineMock);

        assertEquals(felineMock, cat.predator);
    }

    // Проверка метода getSound()
    @Test
    void testGetSound() {
        Feline felineMock = Mockito.mock(Feline.class);
        Cat cat = new Cat(felineMock);

        assertEquals("Мяу", cat.getSound()); // Проверяем, что звук верен
    }

    // Проверка метода getFood()
    @Test
    void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
