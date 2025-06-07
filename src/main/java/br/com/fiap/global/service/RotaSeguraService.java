package br.com.fiap.global.service;

import br.com.fiap.global.model.DTO.RotaSeguraDTO;
import br.com.fiap.global.model.RotaSegura;
import br.com.fiap.global.repository.RotaSeguraRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RotaSeguraService {

    @Autowired
    private RotaSeguraRepository rotaSeguraRepository;

    public RotaSegura criarRotaSegura(RotaSeguraDTO rotaSeguraDTO) {
        RotaSegura rotaSegura = new RotaSegura(rotaSeguraDTO);
        return rotaSeguraRepository.save(rotaSegura);
    }

    public RotaSegura atualizarRotaSegura(RotaSeguraDTO rotaSeguraDTO) {
        if (rotaSeguraDTO.id() == null) {
            throw new IllegalArgumentException("Rota segura não encontrada para atualização");
        }
        RotaSegura rotaSegura = new RotaSegura(rotaSeguraDTO);
        return rotaSeguraRepository.save(rotaSegura);
    }

    public RotaSegura buscarPorId(String id) {
        return rotaSeguraRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nenhuma rota segura encontrada com o id: " + id));
    }

    public List<RotaSegura> listarTodos() {
        return rotaSeguraRepository.findAll();
    }

    public void excluirEndereco(String id) {
        RotaSegura endereco = rotaSeguraRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Endereço não encontrado com o id: " + id));
        rotaSeguraRepository.delete(endereco);
    }
}