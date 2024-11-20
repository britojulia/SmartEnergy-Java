package br.com.fiap.to;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClienteTO {

    @NotBlank private String cpf_cliente;
    @NotBlank private String nome;
    @NotBlank private String email;
    @NotBlank private String endereco;
    private Long telefone;
    @PastOrPresent private LocalDate data_nasc;

    public ClienteTO() {
    }

    public ClienteTO(String cpf_cliente, String nome, String email, String endereco, Long telefone, LocalDate data_nasc) {
        this.cpf_cliente = cpf_cliente;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data_nasc = data_nasc;
    }

    public @NotBlank String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(@NotBlank String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank String endereco) {
        this.endereco = endereco;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public @PastOrPresent LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(@PastOrPresent LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }
}
