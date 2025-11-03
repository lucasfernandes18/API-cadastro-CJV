package dev.java10x.Locadora.API.Usuarios;

import dev.java10x.Locadora.API.Carros.CarroModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapper {
    CarroModel carroModel;


    public UsuarioModel map(UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setIdade(usuarioDTO.getIdade());
        usuarioModel.setCnh(usuarioDTO.getCnh());
        usuarioModel.setCpf(usuarioDTO.getCpf());
        usuarioModel.setCarros(usuarioDTO.getCarros());


        return usuarioModel;

    }


    public UsuarioDTO map(UsuarioModel usuarioModel) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setNome(usuarioModel.getNome());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setIdade(usuarioModel.getIdade());
        usuarioDTO.setCnh(usuarioModel.getCnh());
        usuarioDTO.setCpf(usuarioModel.getCpf());
        usuarioDTO.setCarros(usuarioModel.getCarros());


        return usuarioDTO;
    }
}
