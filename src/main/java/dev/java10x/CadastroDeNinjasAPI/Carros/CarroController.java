package dev.java10x.CadastroDeNinjasAPI.Carros;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @PostMapping("/criar")
    public String criarCarro(){
        return "adicionar veiculo";

    }

    @GetMapping("/listar")
        public String listarCarros(){
            return "mostrar todos os carros";
        }

    @GetMapping("/usuarioID")
    public String motrarUsuariosPorId(){
        return "mostrar veículo";
    }


    @PutMapping("/alterar")
        public String alterarCarro(){
        return "fazer alteração";
    }

    @DeleteMapping("/deletar")
    public String deletarCarro(){
        return "deletar carro";
    }



}
