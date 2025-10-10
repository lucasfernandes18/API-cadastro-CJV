package dev.java10x.CadastroDeNinjasAPI.Usuarios;


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
    public String criarUsuario(){
        return "Usuário criado";
    }

    //mostrar todos os usuarios (read)
    @GetMapping("/listar")
    public List<UsuarioModel> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }



    //mostrar usuário por id (read)

    @GetMapping("/usuarioID")
    public String motrarUsuariosPorId(){
        return "mostrar usuário";
    }



    //Alterar dados dos ninjas (update)
    @PutMapping("/alterar")
    public String alterarUsuario(){
        return "alterar dados do usuário usuario";
    }


    //Deletar Ninja (delete)

    @DeleteMapping("/deletar")
    public String deletarUsuarioPorID (){
        return "deletar usuario";
    }

}
