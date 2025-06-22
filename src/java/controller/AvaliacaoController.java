/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AvaliacaoDAO;
import dao.QuestaoDAO;
import dao.SetorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.AvaliacaoVO;
import vo.QuestaoVO;
import vo.SetorVO;
import vo.RelatorioSetorVO;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class AvaliacaoController extends HttpServlet {

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
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO(); // Só aqui!
            QuestaoDAO questaoDAO = new QuestaoDAO();

            switch (operacao) {
                // Início da avaliação: mostra a primeira pergunta
                case 1 -> {
                    int idSetor = Integer.parseInt(request.getParameter("id_setor"));
                    List<QuestaoVO> questoes = questaoDAO.buscarQuestoes();
                    // Buscar nome do setor
                    SetorDAO setorDAO = new SetorDAO();
                    SetorVO setor = setorDAO.buscarPorId(idSetor);
                    String nomeSetor = setor != null ? setor.getNome() : "Setor";
                    if (!questoes.isEmpty()) {
                        request.setAttribute("id_setor", idSetor);
                        request.setAttribute("nome_setor", nomeSetor); // <-- Adicione esta linha
                        request.setAttribute("questao", questoes.get(0));
                        request.setAttribute("indice", 0);
                        request.setAttribute("total", questoes.size());
                        RequestDispatcher rd = request.getRequestDispatcher("/Avaliacao.jsp");
                        rd.forward(request, response);
                    } else {
                        response.sendRedirect("HomeAvaliacao.jsp?msg=SemQuestoes");
                    }
                }
                // Recebe nota e mostra próxima pergunta ou finaliza
                case 2 -> {
                    int idSetor = Integer.parseInt(request.getParameter("id_setor"));
                    int indice = Integer.parseInt(request.getParameter("indice"));
                    int nota = Integer.parseInt(request.getParameter("nota"));
                    List<QuestaoVO> questoes = questaoDAO.buscarQuestoes();
                    // Buscar nome do setor
                    SetorDAO setorDAO = new SetorDAO();
                    SetorVO setor = setorDAO.buscarPorId(idSetor);
                    String nomeSetor = setor != null ? setor.getNome() : "Setor";

                    // Salva avaliação da pergunta atual
                    if (indice < questoes.size()) {
                        AvaliacaoVO avaliacao = new AvaliacaoVO();
                        avaliacao.setId_setor(idSetor);
                        avaliacao.setId_questao(questoes.get(indice).getId());
                        avaliacao.setNota(nota);
                        avaliacaoDAO.inserirAvaliacao(avaliacao);
                    }

                    // Próxima pergunta ou fim
                    if (indice + 1 < questoes.size()) {
                        request.setAttribute("id_setor", idSetor);
                        request.setAttribute("nome_setor", nomeSetor); // <-- Adicione esta linha
                        request.setAttribute("questao", questoes.get(indice + 1));
                        request.setAttribute("indice", indice + 1);
                        request.setAttribute("total", questoes.size());
                        RequestDispatcher rd = request.getRequestDispatcher("/Avaliacao.jsp");
                        rd.forward(request, response);
                    } else {
                        response.sendRedirect("SetorController?acao=6&msg=AvaliacaoFinalizada");
                    }
                }
                case 3 -> { // Exibir relatório
                    List<RelatorioSetorVO> relatorio = avaliacaoDAO.buscarRelatorioPorSetor();
                    request.setAttribute("relatorio", relatorio);
                    RequestDispatcher rd = request.getRequestDispatcher("/ExibeRelatorio.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("HomeAvaliacao.jsp?msg=Erro");
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
        return "Controller para operações relacionadas a Avaliação.";
    }
}
