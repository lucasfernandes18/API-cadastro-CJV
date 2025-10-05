package dev.java10x.CadastroDeNinjasAPI.Usuarios;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UsuarioController {


    @GetMapping("/boasvindasDoUsuario")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }



}
