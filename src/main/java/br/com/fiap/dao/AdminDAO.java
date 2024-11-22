package br.com.fiap.dao;

import br.com.fiap.to.AdminTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO extends Repository {

    public ArrayList<AdminTO> findAll(){
        ArrayList<AdminTO> admins = new ArrayList<AdminTO>();
        String sql = "select * from admin order by cpf_admin";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()){
                    AdminTO admin = new AdminTO();
                    admin.setCpf_admin(rs.getString("cpf_admin"));
                    admin.setNome(rs.getString("nome"));
                    admin.setEmail(rs.getString("email"));
                    admin.setSenha(rs.getString("senha"));
                    admins.add(admin);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta" + e.getMessage());
        } finally {
            closeConnection();
        }
        return admins;
    }

    public AdminTO findByCodigo(String cpf_admin) {
        AdminTO admin = new AdminTO();
        String sql = "select cpf_admin, nome, email, senha from admin where cpf_admin = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cpf_admin);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                admin.setCpf_admin(rs.getString("cpf_admin"));
                admin.setNome(rs.getString("nome"));
                admin.setEmail(rs.getString("email"));
                admin.setSenha(rs.getString("senha"));
            }  else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return admin;
    }

    public AdminTO save(AdminTO admin) {
        String sql = "insert into admin ( cpf_admin, nome, email, senha) values(?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, admin.getCpf_admin());
            ps.setString(2, admin.getNome());
            ps.setString(3, admin.getEmail());
            ps.setString(4, admin.getSenha());
            if (ps.executeUpdate() > 0) {
                return admin;
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

    public boolean delete(String cpf_admin){
        String sql = "delete from admin where cpf_admin = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, cpf_admin);
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            System.out.println("Erro ao excluir " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public AdminTO update(AdminTO admin){
        String sql = "update admin set nome=?, email=?, senha=? where cpf_admin=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, admin.getNome());
            ps.setString(2, admin.getEmail());;
            ps.setString(3, admin.getSenha());
            ps.setString(4, admin.getCpf_admin());
            if (ps.executeUpdate() > 0){
                return admin;
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
