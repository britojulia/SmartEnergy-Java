package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class EletroTO {

    @NotNull private Long id_eletro;
    @NotBlank private String eletrodomestico;
    private String marca;
    private String eficiencia_energetica;
    @PositiveOrZero private Long potencia;
    @NotBlank private String cpf_cliente;

    public EletroTO() {
    }

    public EletroTO(Long id_eletro, String eletrodomestico, String marca, String eficiencia_energetica, Long potencia, String cpf_cliente) {
        this.id_eletro = id_eletro;
        this.eletrodomestico = eletrodomestico;
        this.marca = marca;
        this.eficiencia_energetica = eficiencia_energetica;
        this.potencia = potencia;
        this.cpf_cliente = cpf_cliente;
    }

    public @NotNull Long getId_eletro() {
        return id_eletro;
    }

    public void setId_eletro(@NotNull Long id_eletro) {
        this.id_eletro = id_eletro;
    }

    public @NotBlank String getEletrodomestico() {
        return eletrodomestico;
    }

    public void setEletrodomestico(@NotBlank String eletrodomestico) {
        this.eletrodomestico = eletrodomestico;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEficiencia_energetica() {
        return eficiencia_energetica;
    }

    public void setEficiencia_energetica(String eficiencia_energetica) {
        this.eficiencia_energetica = eficiencia_energetica;
    }

    public @PositiveOrZero Long getPotencia() {
        return potencia;
    }

    public void setPotencia(@PositiveOrZero Long potencia) {
        this.potencia = potencia;
    }

    public @NotBlank String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(@NotBlank String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
}
