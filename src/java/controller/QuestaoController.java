/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.QuestaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
                    questao.setStatus("ativo");
                    try {
                        questaoDAO.inserirQuestao(questao);
                        response.sendRedirect("HomeAvaliacao.html");
                    } catch (Exception e) {
                        response.sendRedirect("HomeAvaliacao.html");
                    }
                }

                // Listagem dos dados
                case 2 -> {
                    try {
                        List<QuestaoVO> questoes = questaoDAO.buscarQuestoes();
                        request.setAttribute("lista", questoes);
                        RequestDispatcher rd = request.getRequestDispatcher("/ExibeQuestoes.jsp");
                        rd.forward(request, response);
                    } catch (Exception e) {
                        response.sendRedirect("ExibeResultado.jsp?result=2");
                    }
                }

                // Exclusão física (opcional)
                case 3 -> {
                    int id = Integer.parseInt(request.getParameter("id_questao"));
                    try {
                        questaoDAO.excluirQuestao(id);
                        response.sendRedirect("ExibeResultado.jsp?result=1");
                    } catch (Exception e) {
                        response.sendRedirect("ExibeResultado.jsp?result=2");
                    }
                }

                // Inativação lógica
                case 4 -> {
                    int id = Integer.parseInt(request.getParameter("id_questao"));
                    try {
                        questaoDAO.inativarQuestao(id);
                        List<QuestaoVO> questoes = questaoDAO.buscarQuestoes();
                        request.setAttribute("lista", questoes);
                        RequestDispatcher rd = request.getRequestDispatcher("/ExibeQuestoes.jsp");
                        rd.forward(request, response);
                    } catch (Exception e) {
                        response.sendRedirect("ExibeResultado.jsp?result=2");
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
        return "Controller para operações relacionadas a Questao.";
    }
}
