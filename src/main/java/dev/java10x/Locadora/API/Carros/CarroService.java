package dev.java10x.Locadora.API.Carros;

import dev.java10x.Locadora.API.Usuarios.UsuarioMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {
    private CarroRepository carroRepository;
    private CarroMapper carroMapper;

    public CarroService(CarroRepository carroRepository, CarroMapper carroMapper) {
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
    }

    //listar todos os carros
    public List<CarroDTO> listarCarros() {
        List<CarroModel> carros = carroRepository.findAll();
        return carros.stream()
                .map(carroMapper::map)
                .collect(Collectors.toList());
    }

    //listar os carros por id
     public CarroDTO buscarCarrosPorId(Long id){

         Optional<CarroModel> carroId = carroRepository.findById(id);
         return carroId.map(carroMapper::map).orElse(null);
     }

    //criar um novo carro
    public CarroDTO criarCarro(CarroDTO carroDTO){
        CarroModel carro = carroMapper.map(carroDTO);
        carro = carroRepository.save(carro);
        return carroMapper.map(carro);
    }



    // deletar o carro
    public void deletarCarro(Long id){
         carroRepository.deleteById(id);
    }




    //atualizar o carro
public CarroDTO alterarCarro (Long id, CarroDTO carroDTO){
        Optional<CarroModel> carroExistente = carroRepository.findById(id);
        if (carroExistente.isPresent()){
            CarroModel carroAtualizado = carroMapper.map(carroDTO);
            carroAtualizado.setId(id);
            CarroModel carroSalvo = carroRepository.save(carroAtualizado);
    return carroMapper.map(carroSalvo);
        }
        return null;
}














}
