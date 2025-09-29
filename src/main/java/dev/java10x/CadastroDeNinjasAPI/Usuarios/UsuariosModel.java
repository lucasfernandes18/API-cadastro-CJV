package dev.java10x.CadastroDeNinjasAPI.Usuarios;

import jakarta.persistence.*;


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



    public UsuariosModel() {
    }

    public UsuariosModel(long id, String nome, String email, String idade, int cnh) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cnh = cnh;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }
}
