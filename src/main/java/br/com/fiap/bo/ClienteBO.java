package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;

import java.util.ArrayList;

public class ClienteBO {
    public ClienteDAO clienteDAO;

    public ArrayList<ClienteTO> findAll(){
        clienteDAO = new ClienteDAO();
        return clienteDAO.findAll();
    }

    public ClienteTO findByCodigo(String cpf_cliente){
        clienteDAO = new ClienteDAO();
        return clienteDAO.findByCodigo(cpf_cliente);
    }

    public ClienteTO save(ClienteTO cliente){
        clienteDAO = new ClienteDAO();

        //valida se o cpf do cliente possui 11 digitos
        if (cliente.getCpf_cliente() == null || cliente.getCpf_cliente().length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return null;
        }

        //valida se o email é do formato aaaa@aa.com
        if (cliente.getEmail() == null || !cliente.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            System.out.println("Formato de email inválido.");
            return null;
        }

        return clienteDAO.save(cliente);
    }

    public ClienteTO update(ClienteTO cliente){
        clienteDAO = new ClienteDAO();


        //valida se o cpf do cliente possui 11 digitos
        if (cliente.getCpf_cliente() == null || cliente.getCpf_cliente().length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return null;
        }

        //valida se o email é do formato aaaa@aa.com
        if (cliente.getEmail() == null || !cliente.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            System.out.println("Formato de email inválido.");
            return null;
        }

        return clienteDAO.update(cliente);
    }

    public Boolean delete(String cpf_cliente){
        clienteDAO = new ClienteDAO();
        return clienteDAO.delete(cpf_cliente);
    }

}
