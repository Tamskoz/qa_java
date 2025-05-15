package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FelineTest {

    private Feline feline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        feline = spy(new Feline());
    }

    // Проперяем правильный вызов родительского метода
    @Test
    void testEatMeat() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> food = feline.eatMeat();
        verify(feline).getFood(eq("Хищник"));
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), food);
    }

    // Проверим правильность результата getFamily()
    @Test
    void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Проверим метод getKittens с одним котёнком
    @Test
    void testGetKittensDefault() {
        assertEquals(1, feline.getKittens());
    }

    // Проверим метод getKittens с передачей числа котят
    @Test
    void testGetKittensWithArgument() {
        assertEquals(3, feline.getKittens(3));
    }
}
