package dev.java10x.Locadora.API.Carros;

import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public CarroModel map(CarroDTO carroDTO) {
        CarroModel carroModel = new CarroModel();

        carroModel.setId(carroDTO.getId());
        carroModel.setModelo(carroDTO.getModelo());
        carroModel.setPlaca(carroDTO.getPlaca());
        carroModel.setAno(carroDTO.getAno());

        return carroModel;
    }

    public CarroDTO map(CarroModel carroModel) {
        CarroDTO carroDTO = new CarroDTO();

        carroDTO.setId(carroModel.getId());
        carroDTO.setModelo(carroModel.getModelo());
        carroDTO.setPlaca(carroModel.getPlaca());
        carroDTO.setAno(carroModel.getAno());

        return carroDTO;
    }

}