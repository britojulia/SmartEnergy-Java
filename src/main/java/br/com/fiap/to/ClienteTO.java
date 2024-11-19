package br.com.fiap.to;


import java.time.LocalDate;

public class ClienteTO {

    private String cpf_cliente;
    private String nome;
    private String email;
    private String endereco;
    private Long telefone;
    private LocalDate data_nasc;

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

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }
}
