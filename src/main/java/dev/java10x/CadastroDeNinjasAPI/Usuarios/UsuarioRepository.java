package dev.java10x.CadastroDeNinjasAPI.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
