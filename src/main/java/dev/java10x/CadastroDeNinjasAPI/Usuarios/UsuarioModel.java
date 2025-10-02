package dev.java10x.CadastroDeNinjasAPI.Usuarios;

import dev.java10x.CadastroDeNinjasAPI.Carros.CarroModel;
import jakarta.persistence.*;

import java.util.List;


//Entity transforma uma classe em uma entidade do DB
// JPA = java persistence API
@Entity
@Table(name = "tb_usuarios")


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
    @OneToMany(mappedBy = "carros")
    private List<CarroModel> carros;



}