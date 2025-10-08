package dev.java10x.CadastroDeNinjasAPI.Carros;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CarroController {


    @GetMapping("/missoes")
    public String missoes(){
        return "Essa é a parte das missoes";
    }

    //Adicionar carro


}
