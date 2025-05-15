package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LionParameterTest {

    @Mock
    private Predator predatorMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10}) // Разные числа детёнышей
    void testGetKittens(int numKittens) {
        try {
            Lion lion = new Lion(predatorMock, "Самец");
            when(predatorMock.getKittens()).thenReturn(numKittens);
            assertEquals(numKittens, lion.getKittens());
        } catch (Exception e) {
            fail("Неожиданное исключение при создании объекта.", e);
        }
    }


    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testDoesHaveMane(String sex) {
        try {
            Lion lion = new Lion(predatorMock, sex);
            boolean hasMane = lion.doesHaveMane();

            if ("Самец".equals(sex)) {
                assertTrue(hasMane, "Самец должен иметь гриву.");
            } else if ("Самка".equals(sex)) {
                assertFalse(hasMane, "Самка не должна иметь гриву.");
            }
        } catch (Exception e) {
            fail("Неожиданное исключение при создании объекта.", e);
        }
    }

}

