package dev.java10x.Locadora.API.Usuarios;


import dev.java10x.Locadora.API.Carros.CarroDTO;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Rota de criação de novo usuário")
    //@RequestBody faz a serialização inversa dos usuarios do ninja model de volta para o db
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário cadastrado com sucesso " + novoUsuario.getNome() + "ID: " + novoUsuario.getId());
    }

    //mostrar todos os usuarios (read)
    @GetMapping("/listar")
    @Operation(summary = "exibe a lista de usuários")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
       List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    //mostrar usuário por id (read)
    @GetMapping("/usuarioId/{id}")
    @Operation(summary = "exibe os dados do usuário")
    public ResponseEntity<?> listarUsuariosPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);
        if (usuarioService.listarUsuariosPorId(id) != null){
            return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado");
        }
    }

    //Alterar dados dos usu (update)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "altera um usuário por id")
    public ResponseEntity<String> alterarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado) {
       UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);
        if (usuarioService.alterarUsuario(id, usuarioAtualizado) != null){
            return ResponseEntity.ok("o usuario " + usuario.getNome() + " com id: " + id + " alterado com sucesso");
        }else {
            return ResponseEntity.status((HttpStatus.NOT_FOUND))
                    .body("Não foi possível encontrar o usuário");
        }

    }

    //Deletar Usuario (delete)

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "deleta um usuário")
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
