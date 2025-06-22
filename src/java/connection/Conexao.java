/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class Conexao {
    private final String bd;
    private final String usuario;
    private final String senha;
    private Connection con;

    public Conexao() {
        bd = "jdbc:mysql://localhost:3306/sistema_avaliacao?useUnicode=true&characterEncoding=UTF-8";
        usuario = "root";
        senha = "lucas4321";
        con = null;
    }

    public Connection estabeleceConexao() throws SQLException {        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(bd, usuario, senha);
            return con;
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro na conexão: " + erro);
            return null;
        }
    }    
    
    public void fecharConexao() {
        try {
            if (this.con != null && !this.con.isClosed()) {
                this.con.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e);
        }
    }
}

