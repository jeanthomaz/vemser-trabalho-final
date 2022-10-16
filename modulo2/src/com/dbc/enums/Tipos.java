package com.dbc.enums;

import java.util.Arrays;

public enum Tipos {
    JOGOS(1),
    CONSOLE(2),
    COLECIONAVEL(3);

    private Integer tipo;

    Tipos(Integer tipo){

        this.tipo = tipo;
    }

    public Integer getTipos() {

        return tipo;
    }

    public static Tipos ofTipo(Integer tipo) {
        return Arrays.stream(Tipos.values())
                .filter(tp -> tp.getTipos().equals(tipo))
                .findFirst()
                .get();
    }
}