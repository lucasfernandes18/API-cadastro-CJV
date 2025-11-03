
package dev.java10x.Locadora.API.Carros;

import dev.java10x.Locadora.API.Usuarios.UsuarioModel;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarroDTO {

    Long id;
    private String modelo;
    private String placa;
    private int ano;
    private String cor;
    private UsuarioModel usuario;


}
