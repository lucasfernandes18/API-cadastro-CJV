package dev.java10x.CadastroDeNinjasAPI.Usuarios;

import dev.java10x.CadastroDeNinjasAPI.Carros.CarrosModel;
import jakarta.persistence.*;

import java.util.List;


//Entity transforma uma classe em uma entidade do DB
// JPA = java persistence API
@Entity
@Table(name = "tb_usuarios")


public class UsuariosModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String nome;

    private String email;

    private String idade;

    private int cnh;

    //um usuário pode locar vários carros
    @OneToMany(mappedBy = "carros")
    private List<CarrosModel> carros;



}