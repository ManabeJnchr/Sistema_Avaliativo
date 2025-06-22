/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.UsuarioVO;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class UsuarioController extends HttpServlet {

    /**
     * Processa requisições HTTP tanto do tipo <code>GET</code> quanto <code>POST</code>.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException se ocorrer um erro específico do servlet
     * @throws IOException se ocorrer um erro de I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            int operacao = Integer.parseInt(request.getParameter("acao"));
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            switch (operacao) {
                // Login
                case 1 -> {
                    String nome = request.getParameter("nome");
                    String senha = request.getParameter("senha");
                    UsuarioVO usuario = usuarioDAO.buscarPorNomeESenha(nome, senha);
                    if (usuario != null) {
                        // Login OK, salva na sessão
                        HttpSession session = request.getSession();
                        session.setAttribute("usuarioLogado", usuario);
                        response.sendRedirect("SetorController?acao=6");
                    } else {
                        // Login inválido, volta para home com erro
                        response.sendRedirect("SetorController?acao=6&login=erro");
                    }
                }
            }
        } catch (Exception e) {
            response.sendRedirect("SetorController?acao=6&login=erro");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controller para operações relacionadas a Questao.";
    }
}
