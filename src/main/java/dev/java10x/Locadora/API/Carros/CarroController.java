package dev.java10x.Locadora.API.Carros;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping("/criar")
    public CarroModel criarCarro(@RequestBody CarroModel carro){
        return carroService.criarCarro(carro);
    }

    @GetMapping("/listar")
    public List<CarroModel> listarCarros(){
        return carroService.listarCarros();
    }

    @GetMapping("/carroId/{id}")
    public CarroModel carroId(@PathVariable Long id){
        return carroService.buscarCarrosPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public CarroModel alterarCarro(@RequestBody Long id, CarroModel carroAtualizado){
        return carroService.alterarCarro(id, carroAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCarro(@PathVariable Long id){
        carroService.deletarCarro(id);
    }
}
