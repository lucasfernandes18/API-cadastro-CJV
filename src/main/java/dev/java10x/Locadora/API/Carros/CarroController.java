package dev.java10x.Locadora.API.Carros;

import dev.java10x.Locadora.API.Usuarios.UsuarioDTO;
import dev.java10x.Locadora.API.Usuarios.UsuarioModel;
import dev.java10x.Locadora.API.Usuarios.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private CarroService carroService;
    private UsuarioRepository usuarioRepository;
    private CarroMapper carroMapper;
    private CarroRepository carroRepository;

    public CarroController(CarroService carroService, CarroRepository carroRepository, CarroMapper carroMapper, UsuarioRepository usuarioRepository) {
        this.carroService = carroService;
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
        this.usuarioRepository = usuarioRepository;
    }


    @PostMapping("/criar")
    public ResponseEntity<?> criarCarroAlugado(@RequestBody CarroDTO carroDTO) {
        try {
            CarroDTO carroResponse = carroService.criarCarroAlugado(carroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(carroResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<CarroDTO>> listarCarros(){
        List<CarroDTO> carros = carroService.listarCarros();
        return ResponseEntity.ok(carros);
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
