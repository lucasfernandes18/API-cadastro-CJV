package dev.java10x.CadastroDeNinjasAPI.Carros;

import dev.java10x.CadastroDeNinjasAPI.Usuarios.UsuariosModel;
import jakarta.persistence.*;


//Entity transforma uma classe em uma entidade do DB
// JPA = java persistence API
@Entity
@Table(name = "tb_carros")


public class CarrosModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String modelo;
    private String placa;
    private int ano;
    private UsuariosModel usuario;


    public CarrosModel() {
    }

    public CarrosModel(long id, String modelo, String placa, int ano, UsuariosModel usuario) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public UsuariosModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosModel usuario) {
        this.usuario = usuario;
    }
}
