package dev.java10x.Locadora.API.Usuarios;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Adicionar usuário (create)
    @PostMapping("/criar")
    //@RequestBody faz a serialização inversa dos usuarios do ninja model de volta para o db
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso " + novoUsuario.getNome() + "ID):" + novoUsuario.getId());


    }

    //mostrar todos os usuarios (read)
    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }


    //mostrar usuário por id (read)
    @GetMapping("/usuarioId/{id}")

    public ResponseEntity<String> listarUsuariosPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);
        if (usuarioService.listarUsuariosPorId(id) != null){
            usuarioService.listarUsuariosPorId(id);
            return ResponseEntity.ok("usuário encontrado \n" + usuario );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado");
        }

    }


    //Alterar dados dos usu (update)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado) {
        if (usuarioService.alterarUsuario(id, usuarioAtualizado) != null){
            usuarioService.alterarUsuario(id, usuarioAtualizado);
            return ResponseEntity.ok("usuario com id: " + id + "alterado com sucesso");


        }else {
            return ResponseEntity.status((HttpStatus.NOT_FOUND))
                    .body("Não foi possível encontrar o usuário");
        }

    }


    //Deletar Usuario (delete)

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuarioPorID(@PathVariable Long id) {

        if (usuarioService.listarUsuariosPorId(id) != null) {
            usuarioService.deletarUsuarioId(id);
            return ResponseEntity.ok("usuario com o id: " + id + " deletado com sucesso");

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("o usuario com o id " + id + " não encontrado");
        }


    }
}


