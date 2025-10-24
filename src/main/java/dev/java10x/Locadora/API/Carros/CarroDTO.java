package dev.java10x.Locadora.API.Carros;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarroDTO {

    long id;
    private String modelo;
    private String placa;
    private int ano;
}
