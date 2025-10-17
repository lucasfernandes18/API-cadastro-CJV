package dev.java10x.Locadora.API.Carros;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    private CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    //listar todos os carros
    public List<CarroModel> listarCarros() {
        return carroRepository.findAll();
    }

    //listar os carros por id
     public CarroModel buscarCarrosPorId(Long id){
         Optional<CarroModel> carroId = carroRepository.findById(id);
         return carroId.orElse(null);
     }

    //criar um novo carro
    public CarroModel criarCarro(CarroModel carro){
        return carroRepository.save(carro);
    }

    // deletar o carro
    public void deletarCarro(Long id){
         carroRepository.deleteById(id);
    }




    //atualizar o carro
public CarroModel alterarCarro (Long id, CarroModel carroAtualizado){
        if (carroRepository.existsById(id)){
            carroAtualizado.setId(id);
            return carroRepository.save(carroAtualizado);
        }
        return null;
}














}
