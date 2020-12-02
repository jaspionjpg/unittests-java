package com.richardmartins.testes;

import org.springframework.stereotype.Service;

@Service
public class Somar {

    public int somar(Integer number, Integer number2) {
        return number + number2;
    }

}
