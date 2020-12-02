package com.richardmartins.testes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculadora {

    @Autowired
    private Somar somar;

    @Autowired
    private Subtrair subtrair;

    public int calcular(int number, int number2){
        return somar.somar(number, number2);
    }

}
