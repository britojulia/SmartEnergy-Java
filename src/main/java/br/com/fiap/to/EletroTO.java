package br.com.fiap.to;

public class EletroTO {

    private String eletrodomestico;
    private String marca;
    private String eficiencia_energetica;
    private Long consumo_energetico;
    private String cpf_cliente;

    public EletroTO() {
    }

    public EletroTO(String eletrodomestico, String marca, String eficiencia_energetica, Long consumo_energetico, String cpf_cliente) {
        this.eletrodomestico = eletrodomestico;
        this.marca = marca;
        this.eficiencia_energetica = eficiencia_energetica;
        this.consumo_energetico = consumo_energetico;
        this.cpf_cliente = cpf_cliente;
    }

    public String getEletrodomestico() {
        return eletrodomestico;
    }

    public void setEletrodomestico(String eletrodomestico) {
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

    public Long getConsumo_energetico() {
        return consumo_energetico;
    }

    public void setConsumo_energetico(Long consumo_energetico) {
        this.consumo_energetico = consumo_energetico;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
}
