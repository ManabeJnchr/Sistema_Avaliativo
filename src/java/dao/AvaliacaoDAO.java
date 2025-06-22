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
import vo.RelatorioSetorVO;

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

    public List<RelatorioSetorVO> buscarRelatorioPorSetor() throws SQLException {
        List<RelatorioSetorVO> relatorio = new ArrayList<>();
        Connection con = new Conexao().estabeleceConexao();
        String sql = """
            SELECT s.nome AS nome_setor,
                   COUNT(a.id) AS quantidade_avaliacoes,
                   AVG(a.nota) AS media_avaliacoes
              FROM setor s
              INNER JOIN avaliacao a ON a.id_setor = s.id
             GROUP BY s.id, s.nome
             ORDER BY s.nome
        """;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            RelatorioSetorVO vo = new RelatorioSetorVO();
            vo.setNome_setor(rs.getString("nome_setor"));
            vo.setQuantidade_avaliacoes(rs.getInt("quantidade_avaliacoes"));
            vo.setMedia_avaliacoes(rs.getDouble("media_avaliacoes"));
            relatorio.add(vo);
        }
        rs.close();
        ps.close();
        con.close();
        return relatorio;
    }
}
