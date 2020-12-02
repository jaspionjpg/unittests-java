package com.richardmartins.testes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraMock {

    @InjectMocks
    private Calculadora calculadora;

    @Mock
    private Somar somar;

    @Test
    public void asdf() {
        Mockito.when(somar.somar(1, 1))
                .thenReturn(1);
        int calcular = calculadora.calcular(1, 1);
        Assert.assertEquals(1, calcular);
    }
}
