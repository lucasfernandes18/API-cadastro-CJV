package dev.java10x.Locadora.API.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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





}
