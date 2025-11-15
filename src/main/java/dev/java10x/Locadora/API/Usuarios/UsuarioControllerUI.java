package dev.java10x.Locadora.API.Usuarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    //exibe as informações do usuário
    @GetMapping("/usuarioId/{id}")
    public String listarUsuariosPorId(@PathVariable Long id, Model model) {
        UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "detalhesUsuario"; // Nome do arquivo .html
        } else {
            model.addAttribute("mensagem", "Usuário não encontrado");
            return "listarUsuarios";
        }
    }


    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        UsuarioDTO usuario = usuarioService.listarUsuariosPorId(id);

        if (usuario == null) {
            model.addAttribute("mensagem", "Usuário não encontrado");
            return "redirect:/usuarios/ui";
        }

        model.addAttribute("usuario", usuario);
        return "editarUsuario";
    }



    //criação do usuário
    @GetMapping("/criar")
    public String mostrarFormulárioAdd(Model model){
        model.addAttribute("usuario", new UsuarioDTO());
        return "CriarUsuario";
    }
    @PostMapping("/salvar")
    public String processarCriacao(@ModelAttribute UsuarioDTO usuario, RedirectAttributes redirectAttributes) {
        usuarioService.criarUsuario(usuario);
        redirectAttributes.addAttribute("mensagem", "perfil criado");
        return "redirect:/usuarios/ui/listar";
    }


}




