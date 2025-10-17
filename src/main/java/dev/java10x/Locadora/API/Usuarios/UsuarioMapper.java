package dev.java10x.Locadora.API.Usuarios;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
@Component
public class UsuarioMapper {

    public UsuarioModel map(UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setIdade(usuarioDTO.getIdade());
        usuarioModel.setCnh(usuarioDTO.getCnh());
        usuarioModel.setCpf(usuarioDTO.getCpf());
        usuarioModel.setCor(usuarioDTO.getCor());

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
        usuarioDTO.setCor(usuarioModel.getCor());

        return usuarioDTO;

    }
}
