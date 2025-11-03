package dev.java10x.Locadora.API.Usuarios;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.Locadora.API.Carros.CarroModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


//Entity transforma uma classe em uma entidade do DB
// JPA = java persistence API
@Entity
@Table(name = "tb_usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data // cria todos os getters e setters


public class UsuarioModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private Long id;

    @Column(name = "name")
    private String nome;

    @Column( name = "idade")
    private Integer idade;

    @Column(unique = true)
    private long cpf;

    @Column(unique = true)
    private Integer cnh;

    @Column(unique = true)
    private String email;





    //um usuário pode locar vários carros
    @OneToMany(mappedBy = "usuario")
    private List<CarroModel> carros;


}