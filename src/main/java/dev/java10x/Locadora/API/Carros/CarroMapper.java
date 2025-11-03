package dev.java10x.Locadora.API.Carros;

import dev.java10x.Locadora.API.Usuarios.UsuarioDTO;
import dev.java10x.Locadora.API.Usuarios.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public CarroModel map(CarroDTO carroDTO) {
        CarroModel carroModel = new CarroModel();

        carroModel.setId(carroDTO.getId());
        carroModel.setModelo(carroDTO.getModelo());
        carroModel.setPlaca(carroDTO.getPlaca());
        carroModel.setAno(carroDTO.getAno());
        carroModel.setCor(carroDTO.getCor());
        carroModel.setUsuario(carroDTO.getUsuario());

        return carroModel;
    }

    public CarroDTO map(CarroModel carroModel) {
        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setId(carroModel.getId());
        carroDTO.setModelo(carroModel.getModelo());
        carroDTO.setPlaca(carroModel.getPlaca());
        carroDTO.setAno(carroModel.getAno());
        carroDTO.setCor(carroModel.getCor());
        carroDTO.setUsuario(carroModel.getUsuario());

        return carroDTO;
    }

}