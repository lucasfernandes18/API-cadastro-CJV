package dev.java10x.CadastroDeNinjasAPI.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    //listar os usuários por id
    public UsuarioModel listarUsuariosPorId(Long id){
        Optional<UsuarioModel> usuarioId = usuarioRepository.findById(id);
        return usuarioId.orElse(null);
    }

    //criar um novo usuario
    public UsuarioModel criarUsuario(UsuarioModel usuario) {
      return usuarioRepository.save(usuario);
    }

    //deletar o usuario - tem que ser um método void
    public void deletarUsuarioId(Long id){
         usuarioRepository.deleteById(id);
    }





}
