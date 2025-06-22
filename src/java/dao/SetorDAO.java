/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.Conexao;
import vo.SetorVO;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class SetorDAO {

    public void inserirSetor(SetorVO setor) throws SQLException {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "INSERT INTO setor (nome, status) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, setor.getNome());
        ps.setString(2, "ativo");
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public List<SetorVO> buscarSetores() throws SQLException {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "SELECT * FROM setor WHERE status = 'ativo'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<SetorVO> setores = new ArrayList<>();
        while (rs.next()) {
            SetorVO setor = new SetorVO();
            setor.setId(rs.getInt("id"));
            setor.setNome(rs.getString("nome"));
            setor.setStatus(rs.getString("status"));
            setor.setData_cadastro(rs.getTimestamp("data_cadastro"));
            setor.setData_atualizacao(rs.getTimestamp("data_atualizacao"));
            setores.add(setor);
        }

        rs.close();
        ps.close();
        con.close();
        return setores;
    }

    public void excluirSetor(int id) throws SQLException { 
        Connection con = new Conexao().estabeleceConexao();
        String sql = "DELETE FROM setor WHERE id = ?"; 
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id); 
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void inativarSetor(int id) throws SQLException { 
        Connection con = new Conexao().estabeleceConexao();
        String sql = "UPDATE setor SET status = 'inativo' WHERE id = ?"; 
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id); 
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void editarSetor(SetorVO setor) throws SQLException {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "UPDATE setor SET nome = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, setor.getNome());
        ps.setInt(2, setor.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public SetorVO buscarPorId(int id) throws Exception {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "SELECT * FROM setor WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        SetorVO setor = null;
        if (rs.next()) {
            setor = new SetorVO();
            setor.setId(rs.getInt("id"));
            setor.setNome(rs.getString("nome"));
            // Adicione outros campos se necessário
        }
        rs.close();
        ps.close();
        con.close();
        return setor;
    }
}
