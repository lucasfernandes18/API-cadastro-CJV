package dev.java10x.Locadora.API.Usuarios;


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
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO usuario){

        return usuarioService.criarUsuario(usuario);
    }

    //mostrar todos os usuarios (read)
    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }



    //mostrar usuário por id (read)
    @GetMapping("/usuarioId/{id}")
    //@PathVariable liga uma parte dinamica da url a uma variável
    public UsuarioDTO listarUsuariosPorId(@PathVariable Long id){
       return usuarioService.listarUsuariosPorId(id);
    }



    //Alterar dados dos ninjas (update)
    @PutMapping("/alterar/{id}")
    public UsuarioDTO  alterarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado){
return usuarioService.alterarUsuario(id, usuarioAtualizado);
    }




    //Deletar Ninja (delete)

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuarioPorID (@PathVariable  Long id){
        usuarioService.deletarUsuarioId(id);

    }

}
