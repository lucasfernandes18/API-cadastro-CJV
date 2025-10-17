package dev.java10x.Locadora.API.Usuarios;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    //listar todos os usuários
    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());
    }
    //listar os usuários por id
    public UsuarioModel listarUsuariosPorId(Long id){
        Optional<UsuarioModel> usuarioId = usuarioRepository.findById(id);
        return usuarioId.orElse(null);
    }

    //criar um novo usuario
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
      UsuarioModel usuario = usuarioMapper.map(usuarioDTO);
      usuario = usuarioRepository.save(usuario);
      return usuarioMapper.map(usuario);
    }

    //deletar o usuario - tem que ser um método void
    public void deletarUsuarioId(Long id){
         usuarioRepository.deleteById(id);
    }

    //atualizar um usuário
    public UsuarioModel alterarUsuario(Long id,UsuarioModel usuarioAtualizado){
        if (usuarioRepository.existsById(id)){
            usuarioAtualizado.setId(id);
            return usuarioRepository.save(usuarioAtualizado);
        }
        return null;
    }






}
