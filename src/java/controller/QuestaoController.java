/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.QuestaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.QuestaoVO;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class QuestaoController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            request.setCharacterEncoding("UTF-8");
            
            int operacao = Integer.parseInt(request.getParameter("acao"));
            QuestaoDAO questaoDAO = new QuestaoDAO();
            
            switch (operacao) {
                // Inserção no banco de dados
                case 1 -> {
                    QuestaoVO questao = new QuestaoVO();
                    questao.setPergunta(request.getParameter("pergunta"));                    
                    try {
                        questaoDAO.inserirQuestao(questao);
                        response.sendRedirect("HomeAvaliacao.html");
                    } catch (Exception e) {
                        response.sendRedirect("HomeAvaliacao.html");
                    }
                }
            }
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
        return "Controller para operações relacionadas ao Questoes.";
    }
}
