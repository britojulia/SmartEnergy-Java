package br.com.fiap.to;

public class AdminTO {
    private String cpf_admin;
    private String nome;
    private String email;
    private String senha;

    public AdminTO() {
    }

    public AdminTO(String cpf_admin, String nome, String email, String senha) {
        this.cpf_admin = cpf_admin;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getCpf_admin() {
        return cpf_admin;
    }

    public void setCpf_admin(String cpf_admin) {
        this.cpf_admin = cpf_admin;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
