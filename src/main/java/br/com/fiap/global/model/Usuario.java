package br.com.fiap.global.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@Document(collection = "usuarios")
@Validated
public class Usuario {

    @Id
    private String id;

    @NotNull(message = "O nome é obrigatório.")
    private String nome;

    @NotNull(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotNull(message = "O telefone é obrigatório.")
    @Size(max = 15, message = "O telefone não pode exceder 15 caracteres.")
    private String telefone;

    public Usuario() {}

    public Usuario(String id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}