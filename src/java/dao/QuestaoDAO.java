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
        String sql = "INSERT INTO questao (pergunta) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, questao.getPergunta());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
