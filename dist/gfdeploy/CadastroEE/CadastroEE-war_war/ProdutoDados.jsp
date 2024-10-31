<%-- 
    Document   : ProdutoDados
    Created on : 30 de out. de 2024, 08:10:02
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cadastroee.model.Produtos"%>

<!DOCTYPE html>
<html>
    
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
            crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CadastroEE</title>
    </head>
    
    <body class="container">
        <%
            Produtos produto = (Produtos) request.getAttribute("produto");
            String acao = (produto == null) ? "incluir" : "alterar";
        %>

        <h1><%= "alterar".equals(acao) ? "Alterar Produto" : "Novo Produto" %></h1>
        
        <form class="form" action="ServletProdutoFC" method="post">
            <input type="hidden" name="acao" value="<%= acao%>">
            
            <%
                if ("alterar".equals(acao)) { %>
                    <input type="hidden" name="id" value="<%= produto.getIDProduto() %>">
            <%  
                }
            %>
            
            <div class="mb-3">
                <label for="nome" class="form-label">Nome: </label>
                <input type="text" name="nome" id="nome" class="form-control" 
                    value="<%= produto != null ? produto.getNomeProduto() : "" %>" required>
            </div>
            
            <div class="mb-3">
                <label for="quantidade" class="form-label">Quantidade: </label>
                <input type="number" name="quantidade" id="quantidade" class="form-control" 
                    value="<%= produto != null ? String.valueOf(produto.getQuantidadeProduto()) : "" %>" required>
            </div>
            
            <div class="mb-3">
                <label for="preco" class="form-label">Preço de Venda: </label>
                <input type="number" step="0.01" name="preco" id="preco" class="form-control" 
                    value="<%= produto != null ? String.valueOf(produto.getPrecoVendaBase()) : "" %>" required>
            </div>
            
            <button type="submit" class="btn btn-primary"><%= "alterar".equals(acao) ? "Salvar Alterações" : "Adicionar Produto" %></button>
        </form>
        
    </body>
</html>
