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
import vo.UsuarioVO;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class UsuarioDAO {

    public UsuarioVO buscarPorNomeESenha(String nome, String senha) throws SQLException {
        Connection con = new Conexao().estabeleceConexao();
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        UsuarioVO usuario = null;
        if (rs.next()) {
            usuario = new UsuarioVO();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setData_cadastro(rs.getTimestamp("data_cadastro"));
            usuario.setData_atualizacao(rs.getTimestamp("data_atualizacao"));
        }
        rs.close();
        ps.close();
        con.close();
        return usuario;
    }
}
