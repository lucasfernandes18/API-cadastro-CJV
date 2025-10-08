package dev.java10x.CadastroDeNinjasAPI.Usuarios;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UsuarioController {


    @GetMapping("/boasvindasDoUsuario")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adicionar usuário (create)
    @PostMapping("/criar")
    public String criarUsuario(){
        return "Usuário criado";
    }

    //mostrar todos os usuarios (read)
    @GetMapping("/todos")
    public String motrarUsuarios(){
        return "Mostrar usuàrios";
    }


    //mostrar usuário por id (read)

    @GetMapping("/usuarioID")
    public String motrarUsuariosPorId(){
        return "Mostrar usuàrios por id";
    }



    //Alterar dados dos ninjas (update)
    @PutMapping("/alterarID")
    public String alterarUsuario(){
        return "alterar usuario";
    }


    //Deletar Ninja (delete)

    @DeleteMapping("/deletarID")
    public String deletarUsuarioPorID (){
        return "deletar usuario";
    }

}
