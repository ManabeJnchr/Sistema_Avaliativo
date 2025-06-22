/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SetorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.SetorVO;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class SetorController extends HttpServlet {

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
            SetorDAO setorDAO = new SetorDAO();
            
            switch (operacao) {
                // Inserção no banco de dados
                case 1 -> {
                    SetorVO setor = new SetorVO();
                    setor.setNome(request.getParameter("nomeSetor"));
                    setor.setStatus("ativo");
                    try {
                        setorDAO.inserirSetor(setor);
                        response.sendRedirect("HomeAvaliacao.html");
                    } catch (Exception e) {
                        response.sendRedirect("HomeAvaliacao.html");
                    }
                }
                
                // Listagem dos dados
                case 2 -> {
                    try {
                        List<SetorVO> setores = setorDAO.buscarSetores();
                        request.setAttribute("lista", setores);
                        RequestDispatcher rd = request.getRequestDispatcher("/ExibeSetores.jsp");
                        rd.forward(request, response);
                    } catch (Exception e) {
                        response.sendRedirect("ExibeResultado.jsp?result=2");
                    }
                }
                
                // Exclusão dos dados
                case 3 -> {
                    int id = Integer.parseInt(request.getParameter("id_setor"));
                    try {
                        setorDAO.excluirSetor(id);
                        response.sendRedirect("ExibeResultado.jsp?result=1");
                    } catch (Exception e) {
                        response.sendRedirect("ExibeResultado.jsp?result=2");
                    }
                }
                
                // Inativação dos dados
                case 4 -> {
                    int id = Integer.parseInt(request.getParameter("id_setor"));
                    try {
                        setorDAO.inativarSetor(id);
                        List<SetorVO> setores = setorDAO.buscarSetores();
                        request.setAttribute("lista", setores);
                        RequestDispatcher rd = request.getRequestDispatcher("/ExibeSetores.jsp");
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
        return "Controller para operações relacionadas ao Setor.";
    }
}
