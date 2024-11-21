package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;
import br.com.fiap.to.EletroTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EletroDAO extends Repository{

    public ArrayList<EletroTO> findAll(){
        ArrayList<EletroTO> eletros = new ArrayList<EletroTO>();
        String sql = "select id_eletro, eletrodomestico, marca, eficiencia_energetica, potencia, cpf_cliente from eletro order by id_eletro";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    EletroTO eletro = new EletroTO();
                    eletro.setId_eletro(rs.getLong("id_eletro"));
                    eletro.setEletrodomestico(rs.getString("eletrodomestico"));
                    eletro.setMarca(rs.getString("marca"));
                    eletro.setEficiencia_energetica(rs.getString("eficiencia_energetica"));
                    eletro.setPotencia(rs.getLong("potencia"));
                    eletro.setCpf_cliente(rs.getString("cpf_cliente"));
                    eletros.add(eletro);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return eletros;
    }

    public EletroTO findByCodigo(Long id_eletro) {
        EletroTO eletro = new EletroTO();
        String sql = "select id_eletro, eletrodomestico, marca, eficiencia_energetica, potencia, cpf_cliente from eletro  where id_eletro = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_eletro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                eletro.setId_eletro(rs.getLong("id_eletro"));
                eletro.setEletrodomestico(rs.getString("eletrodomestico"));
                eletro.setMarca(rs.getString("marca"));
                eletro.setEficiencia_energetica(rs.getString("eficiencia_energetica"));
                eletro.setPotencia(rs.getLong("potencia"));
                eletro.setCpf_cliente(rs.getString("cpf_cliente"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return eletro;
    }

    public EletroTO save(EletroTO eletro) {
        String sql = "insert into eletro ( eletrodomestico, marca, eficiencia_energetica, potencia, cpf_cliente) values(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, eletro.getEletrodomestico());
            ps.setString(2, eletro.getMarca());
            ps.setString(3, eletro.getEficiencia_energetica());
            ps.setLong(4, eletro.getPotencia());
            ps.setString(5, eletro.getCpf_cliente());
            if (ps.executeUpdate() > 0) {
                return eletro;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long id_eletro){
        String sql = "delete from eletro where id_eletro = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, id_eletro);
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Erro ao excluir " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public EletroTO update(EletroTO eletro){
        String sql = "update eletro set eletrodomestico=?, marca=?, eficiencia_energetica=?, potencia=?, cpf_cliente=? where id_eletro=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, eletro.getEletrodomestico());
            ps.setString(2, eletro.getMarca());
            ps.setString(3, eletro.getEficiencia_energetica());
            ps.setLong(4, eletro.getPotencia());
            ps.setString(5, eletro.getCpf_cliente());
            ps.setLong(6, eletro.getId_eletro());
            if (ps.executeUpdate() > 0){
                return eletro;
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao atualizar " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
