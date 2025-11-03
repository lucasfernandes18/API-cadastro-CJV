package dev.java10x.Locadora.API.Carros;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.Locadora.API.Usuarios.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
    Long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(unique = true)
    private String placa;

    @Column(name = "ano")
    private int ano;

    @Column (name = "cor")
    private String cor;




    //muitos carros podem estar vinculados a um usuário
    @ManyToOne
    @JoinColumn(name= "usuario_id")//foreing key chave estrangeira
    private UsuarioModel usuario;




}


