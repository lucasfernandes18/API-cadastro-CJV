package dev.java10x.Locadora.API.Usuarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("usuarios/ui")
public class UsuarioControllerUI {
    private UsuarioService usuarioService;

    public UsuarioControllerUI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios"; //precisa retornar o nome da pagina que reendeniza
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuarioPorID(@PathVariable Long id) {
        usuarioService.deletarUsuarioId(id);
        return "redirect:/usuarios/ui/listar";

    }



    @GetMapping("/usuarioId/{id}")
    public String listarUsuariosPorId(@PathVariable Long id, Model model) {
        UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);
        if (usuario != null){
            model.addAttribute("usuarios", usuario);
            return"detalhesUsuario";
        }else {
            model.addAttribute("usuarios", usuario);
            return "listarUsuarios";

        }
    }




}