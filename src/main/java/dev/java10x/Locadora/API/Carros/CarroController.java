package dev.java10x.Locadora.API.Carros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarCarro(@RequestBody CarroDTO carro){
        CarroDTO novoCarro = carroService.criarCarro(carro);
        return ResponseEntity.status((HttpStatus.CREATED))
                .body("Carro cadastrado com sucesso " + novoCarro.getModelo() + "ID: " + novoCarro.getId());
    }

    @GetMapping("/listar")
    public List<CarroDTO> listarCarros(){
        return carroService.listarCarros();
    }

    @GetMapping("/carroId/{id}")
    public ResponseEntity<?> carroId(@PathVariable Long id){
        CarroDTO carro = carroService.buscarCarrosPorId(id);
        if (carroService.buscarCarrosPorId(id) != null){
            return ResponseEntity.ok(carro);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Modelo não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarCarro(@RequestBody Long id, CarroDTO carroAtualizado){
        CarroDTO carro = carroService.buscarCarrosPorId(id);
        if (carroService.alterarCarro(id , carroAtualizado) != null){
            return ResponseEntity.ok("o carro " +carro.getModelo() + " com o id: " + carro.getId() + "alterado com sucesso");

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCarro(@PathVariable Long id){
        if (carroService.buscarCarrosPorId(id) != null){
            carroService.deletarCarro(id);
            return ResponseEntity.ok ("Carro com o id: " + id + "deletado com sucesso");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("o carro com o id  " + id + " não foi encontrado ");

    }
}
