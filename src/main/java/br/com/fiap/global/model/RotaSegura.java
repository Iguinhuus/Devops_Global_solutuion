package br.com.fiap.global.model;

import br.com.fiap.global.model.DTO.RotaSeguraDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rotasegura")
@Validated
public class RotaSegura {
    @Id
    private String id;  // Alterado para ObjectId

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public RotaSegura(RotaSeguraDTO rotaSeguraDTO) {
        this.id = rotaSeguraDTO.id();
        this.bairro = rotaSeguraDTO.bairro();
        this.logradouro = rotaSeguraDTO.logradouro();
        this.cep = rotaSeguraDTO.cep();
        this.numero = rotaSeguraDTO.numero();
        this.cidade = rotaSeguraDTO.cidade();
        this.complemento = rotaSeguraDTO.complemento();
        this.uf = rotaSeguraDTO.uf();
    }
}