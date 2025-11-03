package dev.java10x.Locadora.API.Usuarios;

import dev.java10x.Locadora.API.Carros.CarroDTO;
import dev.java10x.Locadora.API.Carros.CarroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private long cpf;
    private Integer cnh;
    private String email;
    private String usuarios;
    private List<CarroModel> carros;






}
