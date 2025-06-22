<%-- 
    Document   : ExibeQuestoes
    Created on : 17 de jun. de 2025, 22:16:24
    Author     : José Victor, Lucas Felipe, Lucas Samuel
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="vo.QuestaoVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema Avaliativo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@mdi/font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <div class="container-fluid">
        <header class="row justify-content-center" style="height: 30vh; background-color: #1A80D9;">
            <div class="col-3 align-content-center text-start h-100">
                <img style="height: 28vh;" src="img/plus.png" alt="Ícone de adição">
            </div>
            <div class="col-6 h-100" style="justify-items: center;">
                <a href="SetorController?acao=6">
                    <img style="height: 80%;" src="img/logo_hospital_central.png" alt="Logo do Hospital Central">
                </a>
                <h5 class="text-end text-white text-decoration-underline"
                    style="position: relative; top: -3.5vh; right: -7.4vw;">Sistema de Avaliação e Desempenho</h5>
            </div>
            <div class="col-3 align-content-center text-end h-100">
                <img style="height: 28vh;" src="img/plus.png" alt="Ícone de adição">
            </div>
        </header>
        <div class="row justify-content-center" style="height: 70vh;">
            <div class="col-11 col-sm-9 col-md-8 rounded-5 py-2"
                style="background-color: #FFFFFF; position: relative; top: -20px;">
                <div class="row justify-content-end">
                    <div class="col-12 col-sm-10 col-md-8">
                        <h4 class="text-center text-black text-decoration-underline fw-bold mb-3">Questões</h4>
                    </div>
                    <div class="col-12 col-sm-2 d-inline-flex justify-content-end">
                        <a href="CadastroQuestao.jsp" class="text-decoration-none text-black mx-2"
                            style="font-size: larger;" title="Cadastrar Questão">
                            <i class="mdi mdi-comment-plus"></i>
                        </a>
                        <a href="SetorController?acao=6" class="text-decoration-none text-black mx-2"
                            style="font-size: larger;" title="Home Page">
                            <i class="mdi mdi-home-outline"></i>
                        </a>
                    </div>
                </div>
                <div class="row" style="max-height: 60vh;">
                    <div class="col-12">
                        <div class="table-responsive" style="max-height: 60vh; overflow-x: auto;">
                            <table class="table table-striped table-hover align-middle">
                                <thead class="table-primary">
                                    <tr>
                                        <th scope="col">Pergunta</th>
                                        <th scope="col">Data de Cadastro</th>
                                        <th scope="col">Data de Atualização</th>
                                        <th scope="col">Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                        List<QuestaoVO> questoes = (List<QuestaoVO>) request.getAttribute("lista");
                                        if (questoes != null && !questoes.isEmpty()) {
                                            for (QuestaoVO questao : questoes) {
                                    %>
                                    <tr>
                                        <td><%= questao.getPergunta() %></td>
                                        <td>
                                            <%= questao.getData_cadastro() != null ? sdf.format(new Date(questao.getData_cadastro().getTime())) : "" %>
                                        </td>
                                        <td>
                                            <%= questao.getData_atualizacao() != null ? sdf.format(new Date(questao.getData_atualizacao().getTime())) : "" %>
                                        </td>
                                        <td>
                                            <!-- Botão Editar -->
                                            <button type="button"
                                                class="btn btn-warning btn-sm me-1"
                                                title="Editar"
                                                data-bs-toggle="modal"
                                                data-bs-target="#modalEditarQuestao"
                                                data-id="<%= questao.getId() %>"
                                                data-pergunta="<%= questao.getPergunta().replace("\"", "&quot;") %>">
                                                <i class="mdi mdi-pencil"></i>
                                            </button>
                                            <!-- Botão Inativar -->
                                            <form method="post" action="QuestaoController?acao=4" style="display:inline;">
                                                <input type="hidden" name="id_questao" value="<%= questao.getId() %>">
                                                <button type="submit" class="btn btn-danger btn-sm" title="Inativar">
                                                    <i class="mdi mdi-delete"></i>
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                    <%
                                            }
                                        } else {
                                    %>
                                    <tr>
                                        <td colspan="4" class="text-center">Nenhuma questão cadastrada.</td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal de Edição de Questão -->
    <div class="modal fade" id="modalEditarQuestao" tabindex="-1" aria-labelledby="modalEditarQuestaoLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <form method="post" action="QuestaoController?acao=5" accept-charset="UTF-8">
                <div class="modal-content">
                    <div class="modal-header" style="background-color: #1A80D9;">
                        <h5 class="modal-title text-white" id="modalEditarQuestaoLabel">Editar Questão</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fechar"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="edit-id-questao" name="id_questao">
                        <div class="mb-3">
                            <label for="edit-pergunta-questao" class="form-label fw-bold">Pergunta</label>
                            <textarea class="form-control" id="edit-pergunta-questao" name="pergunta" required></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-custom-blue">Salvar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var modalEditarQuestao = document.getElementById('modalEditarQuestao');
            modalEditarQuestao.addEventListener('show.bs.modal', function (event) {
                var button = event.relatedTarget;
                var idQuestao = button.getAttribute('data-id');
                var perguntaQuestao = button.getAttribute('data-pergunta');
                document.getElementById('edit-id-questao').value = idQuestao;
                document.getElementById('edit-pergunta-questao').value = perguntaQuestao;
            });
        });
    </script>
</body>

</html>
<%
    if (session.getAttribute("usuarioLogado") == null) {
        response.sendRedirect("HomeAvaliacao.jsp?login=necessario");
        return;
    }
%>