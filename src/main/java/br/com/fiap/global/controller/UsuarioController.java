package br.com.fiap.global.controller;

import br.com.fiap.global.model.DTO.UsuarioDTO;
import br.com.fiap.global.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarios = usuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/listar";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "usuarios/form";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO) {
        try {
            if (usuarioDTO.getId() == null || usuarioDTO.getId().isBlank()) {
                usuarioService.salvar(usuarioDTO);
            } else {
                usuarioService.atualizar(usuarioDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage());
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable String id, Model model) {
        UsuarioDTO usuarioDTO = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "usuarios/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable String id) {
        usuarioService.excluir(id);
        return "redirect:/usuarios";
    }
}