package dev.java10x.CadastroDeNinjasAPI;

import jakarta.persistence.*;


//Entity transforma uma classe em uma entidade do DB
// JPA = java persistence API
@Entity
@Table(name = "tb_cadastro")


public class NinjaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String nome;
    private String email;
    private String idade;


    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, String idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
