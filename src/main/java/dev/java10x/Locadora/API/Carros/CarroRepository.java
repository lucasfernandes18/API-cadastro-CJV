package dev.java10x.Locadora.API.Carros;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroModel, Long> {
}
