package br.com.fiap.global.controller;


import br.com.fiap.global.model.DTO.RotaSeguraDTO;
import br.com.fiap.global.model.RotaSegura;
import br.com.fiap.global.service.RotaSeguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/rotasegura")
public class RotaSeguraController {

    @Autowired
    private RotaSeguraService rotaSeguraService;


    @GetMapping("/cadastrar")
    public String exibirFormCadastro(Model model) {
        model.addAttribute("RotaSegura", new RotaSegura());
        return "rotasegura/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarRotaSegura(@ModelAttribute("RotaSeguraDTO") RotaSeguraDTO rotaSeguraDTO)
    {
        if(rotaSeguraDTO.id() == null) {
            rotaSeguraService.criarRotaSegura(rotaSeguraDTO);
        }else{
            rotaSeguraService.atualizarRotaSegura(rotaSeguraDTO);
        }
        return "redirect:/api/rotasegura/listar";
    }

    @GetMapping("/listar")
    public String listaRotaSegura(Model model) {
        List<RotaSegura> page = rotaSeguraService.listarTodos();
        model.addAttribute("listaRotaSegura", page);
        return "rotasegura/listar";
    }


    @GetMapping("/editar/{id}")
    public String atualizarRotaSegura(
            @PathVariable String id,  // Altere para String
            Model model
    ) {
        // Convertendo o id de String para ObjectId
        String objectId = new String(id);
        RotaSegura rotaSegura = rotaSeguraService.buscarPorId(objectId);
        RotaSeguraDTO dto = new RotaSeguraDTO(
                rotaSegura.getId(),
                rotaSegura.getLogradouro(),
                rotaSegura.getBairro(),
                rotaSegura.getCep(),
                rotaSegura.getNumero(),
                rotaSegura.getComplemento(),
                rotaSegura.getCidade(),
                rotaSegura.getUf()
        );
        model.addAttribute("RotaSeguraDTO", dto);

        return "rotasegura/editar";
    }


    @GetMapping("/{id}")
    public String excluirUsuario(@PathVariable String id) {
        String objectId = new String(id);
        rotaSeguraService.excluirEndereco(objectId);
        return "redirect:/api/rotasegura/listar";
    }

}
