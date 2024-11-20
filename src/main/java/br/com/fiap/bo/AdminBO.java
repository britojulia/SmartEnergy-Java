package br.com.fiap.bo;

import br.com.fiap.dao.AdminDAO;
import br.com.fiap.to.AdminTO;

import java.util.ArrayList;

public class AdminBO {
    public AdminDAO adminDAO;

    public ArrayList<AdminTO> findAll(){
        adminDAO = new AdminDAO();
        return adminDAO.findAll();
    }

    public AdminTO findByCodigo(String cpf_admin){
        adminDAO = new AdminDAO();
        return adminDAO.findByCodigo(cpf_admin);
    }

    public AdminTO save(AdminTO admin){
        adminDAO = new AdminDAO();

        //valida se o cpf do administrador possui 11 digitos
        if (admin.getCpf_admin() == null || admin.getCpf_admin().length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return null;
        }

        //valida se o email é do formato aaaa@aa.com
        if (admin.getEmail() == null || !admin.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            System.out.println("Formato de email inválido.");
            return null;
        }

        return adminDAO.save(admin);
    }

    public AdminTO update(AdminTO admin){
        adminDAO = new AdminDAO();

        //valida se o cpf do administrador possui 11 digitos
        if (admin.getCpf_admin() == null || admin.getCpf_admin().length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return null;
        }

        //valida se o email é do formato aaaa@aa.com
        if (admin.getEmail() == null || !admin.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            System.out.println("Formato de email inválido.");
            return null;
        }

        return adminDAO.update(admin);
    }

    public Boolean delete(String cpf_admin){
        adminDAO = new AdminDAO();
        return adminDAO.delete(cpf_admin);
    }

}
