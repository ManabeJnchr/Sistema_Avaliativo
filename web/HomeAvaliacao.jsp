<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="vo.SetorVO" %>
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
                    style="position: relative; top: -3.5vh; right: -7.4vw;">Sistema de Avaliação e Desenpenho</h4>
            </div>
            <div class="col-3 align-content-center text-end h-100">
                <img style="height: 28vh;" src="img/plus.png" alt="Ícone de adição">
            </div>
        </header>
        <div class="row justify-content-center" style="height: 70vh;">
            <div class="col-11 col-sm-9 col-md-8 rounded-5 py-2" style="background-color: #FFFFFF; position: relative; top: -20px;">
                <div class="row justify-content-end">
                    <div class="col-12 col-sm-10 col-md-8">
                        <h4 class="text-center text-black text-decoration-underline fw-bold mb-3"> Selecione o setor
                            para
                            avaliar</h4>
                    </div>
                    <div class="col-12 col-sm-2 d-inline-flex justify-content-end">
                        <!-- Link para Listar Setor -->
                        <a href="SetorController?acao=2" class="text-decoration-none text-black mx-2"
                            style="font-size: larger;" title="Listar Setor">
                            <i class="mdi mdi-domain"></i>
                        </a>

                        <!-- Link para Listar Questões -->
                        <a href="QuestaoController?acao=2" class="text-decoration-none text-black mx-2"
                            style="font-size: larger;" title="Listar Questões">
                            <i class="mdi mdi-comment-question"></i>
                        </a>

                    </div>
                </div>
                <div class="row overflow-y-auto" style="max-height: 60vh;">
                    <%
                        List<SetorVO> setores = (List<SetorVO>) request.getAttribute("lista");
                        if (setores != null && !setores.isEmpty()) {
                            for (SetorVO setor : setores) {
                                String nome = setor.getNome();
                                String abreviado = nome.length() >= 3 ? nome.substring(0, 3).toUpperCase() : nome.toUpperCase();
                    %>
                    <div class="col-6 col-md-4 col-lg-3 col-xl-2 text-center">
                        <div class="ratio ratio-1x1 w-100">
                            <button onclick="window.location.href='AvaliacaoController?acao=1&id_setor=<%= setor.getId() %>'" class="btn btn-setor-azul d-flex align-items-center justify-content-center w-100 h-100 fs-1 fs-md-1 fs-lg-1 fs-xl-1 fs-2">
                                <%= abreviado %>
                            </button>
                        </div>
                        <span class="fw-bold text-truncate d-block mb-2" style="font-size: small; white-space: nowrap;"><%= nome %></span>
                    </div>
                    <%
                            }
                        } else {
                    %>
                    <div class="col-12 text-center">
                        <span class="fw-bold">Nenhum setor cadastrado.</span>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>

        <!-- Toast de sucesso -->
        <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
            <div id="successToast" class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true"
                <% if (!"AvaliacaoFinalizada".equals(request.getParameter("msg"))) { %> style="display:none;" <% } %>>
                <div class="d-flex">
                    <div class="toast-body">
                        Avaliação finalizada com sucesso!
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
    <% if ("AvaliacaoFinalizada".equals(request.getParameter("msg"))) { %>
    <script>
        window.onload = function () {
            var toastEl = document.getElementById('successToast');
            var toast = new bootstrap.Toast(toastEl);
            toast.show();
        };
    </script>
    <% } %>
</body>

</html>