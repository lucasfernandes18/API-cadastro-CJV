package dev.java10x.CadastroDeNinjasAPI.Carros;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CarroController {

    @GetMapping("/listar")
        public String listarCarros(){
            return "listar os carros";
        }

    @GetMapping("carros")
    public String carros(){
        return "Essa é a parte dos carros";
    }

    @PostMapping("/criar")
    public String criarCarro(){
        return "criarCarro";

}
    @PutMapping("/alterar")
        public String alterarCarro(){
        return "alterar carro";
    }


    @DeleteMapping("/deletar")
    public String deletarCarro(){
        return "deletar carro";
    }


}
