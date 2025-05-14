<%-- 
    Document   : ExibeResultado
    Created on : 11 de mai. de 2025, 13:11:29
    Author     : José Victor, Lucas Felipe, Lucas Samuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="2; URL=SetorController?acao=2">
        <title>Resultado</title>
    </head>
    <body>
    <center>
        <h1>
            <%

                int resultado = Integer.parseInt(request.getParameter("result"));
                if (resultado == 1) {
                    out.print("<font color=\"blue\">SUCESSO</font>");
                } else {
                    out.print("<font color=\"red\">ERRO</font>");
                }

            %>
        </h1>
    </center>
</body>
</html>
