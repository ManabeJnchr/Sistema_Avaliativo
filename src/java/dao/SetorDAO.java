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
        String sql = "INSERT INTO setor (nome) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, setor.getNome());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public List<SetorVO> buscarSetores() throws SQLException {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "SELECT * FROM setor";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<SetorVO> setores = new ArrayList<>();
        while (rs.next()) {
            SetorVO setor = new SetorVO();
            setor.setId(rs.getInt("id"));
            setor.setNome(rs.getString("nome"));
            setor.setDataCriacao(rs.getTimestamp("data_criacao"));
            setor.setDataAtualizacao(rs.getTimestamp("data_atualizacao"));
            setores.add(setor);
        }

        rs.close();
        ps.close();
        con.close();
        return setores;
    }

    public void excluirSetor(int id_setor) throws SQLException { 
        Connection con = new Conexao().estabeleceConexao();
        String sql = "DELETE FROM setor WHERE id_setor = ?"; 
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id_setor); 
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
