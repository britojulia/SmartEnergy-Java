package br.com.fiap.bo;

import br.com.fiap.dao.EletroDAO;
import br.com.fiap.to.EletroTO;

import java.util.ArrayList;

public class EletroBO {
    public EletroDAO eletroDAO;

    public ArrayList<EletroTO> findAll(){
        eletroDAO = new EletroDAO();
        return eletroDAO.findAll();
    }

    public EletroTO findByCodigo(Long id_eletro){
        eletroDAO = new EletroDAO();
        return eletroDAO.findByCodigo(id_eletro);
    }

    public EletroTO save(EletroTO eletro){
        eletroDAO = new EletroDAO();

        //valida se o eletrodomestico possui um nome valido, e nao vazio ou uma letra
        if (eletro.getEletrodomestico() == null || eletro.getEletrodomestico().length() < 3) {
            System.out.println("O nome do eletrodomestico é curto demais ou inválido.");
            return null;
        }

        //valida se a marca possui um nome valido, e nao vazio ou uma letra
        if (eletro.getMarca().length() < 2) {
            System.out.println("O nome da marca é curto demais ou inválido.");
            return null;
        }

        // Valida se a eficiência energética é válida
        if (!eletro.eficienciaEnergeticaValida()) {
            System.out.println("Eficiência energética inválida. Deve A+++, A++, A+, A, B, C, D, E, F ou G.");
            return null;
        }

        //valida se a potência é válida ( maior que zero)
        if (eletro.getPotencia() <= 0) {
            System.out.println("Potência inválida. Deve ser um valor positivo.");
            return null;
        }

        //valida se o cpf do cliente possui 11 digitos
        if (eletro.getCpf_cliente() == null || eletro.getCpf_cliente().length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return null;
        }
        return eletroDAO.save(eletro);
    }

    public EletroTO update(EletroTO eletro){
        eletroDAO = new EletroDAO();

        //valida se o eletrodomestico possui um nome valido, e nao vazio ou uma letra
        if (eletro.getEletrodomestico() == null || eletro.getEletrodomestico().length() < 3) {
            System.out.println("O nome do eletrodomestico é curto demais ou inválido.");
            return null;
        }

        //valida se a marca possui um nome valido, e nao vazio ou uma letra
        if (eletro.getMarca().length() < 2) {
            System.out.println("O nome da marca é curto demais ou inválido.");
            return null;
        }

        // Valida se a eficiência energética é válida
        if (!eletro.eficienciaEnergeticaValida()) {
            System.out.println("Eficiência energética inválida. Deve A+++, A++, A+, A, B, C, D, E, F ou G.");
            return null;
        }


        //valida se a potência é válida ( maior que zero)
        if (eletro.getPotencia() <= 0) {
            System.out.println("Potência inválida. Deve ser um valor positivo.");
            return null;
        }

        //valida se o cpf do cliente possui 11 digitos
        if (eletro.getCpf_cliente() == null || eletro.getCpf_cliente().length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return null;
        }
        return eletroDAO.update(eletro);
    }

    public Boolean delete(Long id_eletro){
        eletroDAO = new EletroDAO();
        return eletroDAO.delete(id_eletro);
    }
}
