package dev.java10x.CadastroDeNinjasAPI.Usuarios;

import dev.java10x.CadastroDeNinjasAPI.Carros.CarroModel;
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
    long id;

    @Column(name = "name")
    private String nome;

    @Column( name = "idade")
    private String idade;

    @Column(unique = true)
    private long cpf;

    @Column(unique = true)
    private int cnh;

    @Column(unique = true)
    private String email;




    //um usuário pode locar vários carros
    @OneToMany(mappedBy = "usuario") //mapeia todos os carros que esse usuário tem
    private List<CarroModel> carros;



}