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
import vo.AvaliacaoVO;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class AvaliacaoDAO {

    public void inserirAvaliacao(AvaliacaoVO avaliacao) throws SQLException {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "INSERT INTO avaliacao (id_setor, id_questao, nota) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, avaliacao.getId_setor());
        ps.setInt(2, avaliacao.getId_questao());
        ps.setInt(3, avaliacao.getNota());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
