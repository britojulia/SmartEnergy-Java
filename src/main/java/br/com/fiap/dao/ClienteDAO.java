package br.com.fiap.dao;

import br.com.fiap.to.AdminTO;
import br.com.fiap.to.ClienteTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteDAO extends Repository{

    public ArrayList<ClienteTO> findAll(){
        ArrayList<ClienteTO> clientes = new ArrayList<ClienteTO>();
        String sql = "select * from cliente_energy order by cpf_cliente";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    ClienteTO cliente = new ClienteTO();
                    cliente.setCpf_cliente(rs.getString("cpf_cliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setTelefone(rs.getLong("telefone"));
                    cliente.setData_nasc(rs.getDate("data_nasc").toLocalDate());
                    clientes.add(cliente);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public ClienteTO findByCodigo(String cpf_cliente) {
        ClienteTO cliente = new ClienteTO();
        String sql = "select cpf_cliente, nome, email, endereco, telefone, data_nasc from cliente_energy where cpf_cliente = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cpf_cliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new ClienteTO();
                cliente.setCpf_cliente(rs.getString("cpf_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getLong("telefone"));
                cliente.setData_nasc(rs.getDate("data_nasc").toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }

    public ClienteTO save(ClienteTO cliente) {
        String sql = "insert into cliente_energy ( cpf_cliente, nome, email, endereco, telefone, data_nasc) values(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cliente.getCpf_cliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getEndereco());
            ps.setLong(5, cliente.getTelefone());
            ps.setDate(6, Date.valueOf(cliente.getData_nasc()));
            if (ps.executeUpdate() > 0) {
                return cliente;
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

    public boolean delete(String cpf_cliente){
        String sql = "delete from cliente_energy where cpf_cliente = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cpf_cliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Erro ao excluir " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ClienteTO update(ClienteTO cliente){
        String sql = "update cliente_energy cpf_cliente set nome=?, email=?, endereco=?, telefone=?, data_nasc=? where cpf_cliente=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());;
            ps.setString(3, cliente.getEndereco());
            ps.setLong(4, cliente.getTelefone());
            ps.setDate(5, Date.valueOf(cliente.getData_nasc()));
            ps.setString(6, cliente.getCpf_cliente());
            if (ps.executeUpdate() > 0){
                return cliente;
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
