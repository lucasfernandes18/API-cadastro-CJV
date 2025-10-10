package dev.java10x.CadastroDeNinjasAPI.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //listar todos os usuários
    public List<UsuarioModel> listarUsuarios( ){
        return usuarioRepository.findAll();
    }



}
