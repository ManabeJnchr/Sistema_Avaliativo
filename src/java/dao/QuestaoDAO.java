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
import vo.QuestaoVO;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class QuestaoDAO {

    public void inserirQuestao(QuestaoVO questao) throws SQLException {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "INSERT INTO questao (questao) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, questao.getQuestao());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public List<QuestaoVO> buscarQuestoes() throws SQLException {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "SELECT * FROM questao";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<QuestaoVO> questoes = new ArrayList<>();
        while (rs.next()) {
            QuestaoVO questao = new QuestaoVO();
            questao.setId(rs.getInt("id"));
            questao.setQuestao(rs.getString("questao"));
            // questao.setDataCriacao(rs.getTimestamp("data_criacao"));
            // questao.setDataAtualizacao(rs.getTimestamp("data_atualizacao"));
            questoes.add(questao);
        }

        rs.close();
        ps.close();
        con.close();
        return questoes;
    }

    public void excluirQuestao(int id_questao) throws SQLException { 
        Connection con = new Conexao().estabeleceConexao();
        String sql = "DELETE FROM questao WHERE id_questao = ?"; 
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id_questao); 
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
