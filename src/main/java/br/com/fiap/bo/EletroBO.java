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

        return eletroDAO.save(eletro);
    }

    public EletroTO update(EletroTO eletro){
        eletroDAO = new EletroDAO();

        return eletroDAO.update(eletro);
    }

    public Boolean delete(Long id_eletro){
        eletroDAO = new EletroDAO();
        return eletroDAO.delete(id_eletro);
    }
}
