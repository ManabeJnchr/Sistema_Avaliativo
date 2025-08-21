<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <div class="col-11 col-sm-9 col-md-8 rounded-5 py-2" style="background-color: #FFFFFF; position: relative; top: -20px;">
                <div class="row justify-content-end">
                    <div class="col-12 col-sm-10 col-md-8">
                        <h4 class="text-center text-black text-decoration-underline fw-bold mb-3">
                            Setor: ${nome_setor}
                        </h4>
                    </div>
                    <div class="col-12 col-sm-2 d-inline-flex justify-content-end">
                        <!-- Link para Home Page -->
                        <a href="SetorController?acao=6" class="text-decoration-none text-black mx-2"
                            style="font-size: larger;" title="Home Page">
                            <i class="mdi mdi-home-outline"></i>
                        </a>

                    </div>
                </div>
                <div class="row overflow-y-auto" style="max-height: 60vh;">
                    <div class="col-12 text-center">
                        <h3>Pergunta ${indice + 1} de ${total}</h3>
                        <p class="mt-5" style="font-size: 25px;">${questao.pergunta}</p>
                        <form method="post" action="AvaliacaoController">
                            <input type="hidden" name="acao" value="2">
                            <input type="hidden" name="id_setor" value="${id_setor}">
                            <input type="hidden" name="indice" value="${indice}">
                            <div class="btn-group" role="group">
                                <button type="submit" name="nota" value="0" class="btn btn-primary mx-1" style="font-size: 40px;">0</button>
                                <button type="submit" name="nota" value="1" class="btn btn-primary mx-1" style="font-size: 40px;">1</button>
                                <button type="submit" name="nota" value="2" class="btn btn-primary mx-1" style="font-size: 40px;">2</button>
                                <button type="submit" name="nota" value="3" class="btn btn-primary mx-1" style="font-size: 40px;">3</button>
                                <button type="submit" name="nota" value="4" class="btn btn-primary mx-1" style="font-size: 40px;">4</button>
                                <button type="submit" name="nota" value="5" class="btn btn-primary mx-1" style="font-size: 40px;">5</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
</body>

</html>