package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @Mock
    private Predator predatorMock;

    private Lion lionMale;
    private Lion lionFemale;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        try {
            lionMale = new Lion(predatorMock, "Самец");
            lionFemale = new Lion(predatorMock, "Самка");
        } catch (Exception e) {
            fail("Неожиданная ошибка при создании объекта.");
        }
    }

    @Test
    void testConstructorValidArguments() {
        assertNotNull(lionMale);
        assertNotNull(lionFemale);
    }

    @Test
    void testConstructorInvalidSex() {
        try {
            new Lion(predatorMock, "бесполое существо");
            fail("Должно  возникнуть исключение.");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Используйте допустимые значения пола животного"));
        }
    }
    @Test
    void testConstructor() {
        assertTrue(lionMale.doesHaveMane());      // Самец должен иметь гриву
        assertFalse(lionFemale.doesHaveMane());   // Самка не должна иметь гриву
    }

    // Проверяем метод getKittens()
    @Test
    void testGetKittens() {
        when(predatorMock.getKittens()).thenReturn(3);
        assertEquals(3, lionMale.getKittens());
    }

    @Test
    void testDoesHaveManeFemale() {
        assertFalse(lionFemale.doesHaveMane(), "Самка не должна иметь гриву.");
    }

    // Проверяем метод getFood()
    @Test
    void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.getFood(anyString())).thenReturn(expectedFood);
        List<String> actualFood = lionMale.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
