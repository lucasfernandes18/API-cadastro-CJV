package dev.java10x.CadastroDeNinjasAPI.Carros;

import dev.java10x.CadastroDeNinjasAPI.Usuarios.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Entity transforma uma classe em uma entidade do DB
// JPA = java persistence API

@Entity
@Table(name = "tb_carros")
@NoArgsConstructor
@AllArgsConstructor
@Data // cria todos os getters e setters


public class CarroModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(unique = true)
    private String placa;

    @Column(name = "ano")
    private int ano;

    //muitos carros podem estar vinculados a um usuário
    @ManyToOne
    @JoinColumn(name = "usuarios_id") //foreing key chave estrangeira
    private UsuarioModel usuario;




}


