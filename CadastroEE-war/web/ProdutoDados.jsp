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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CadastroEE</title>
    </head>
    
    <body>
        <h1><%= request.getAttribute("acao") != null && request.getAttribute("acao").equals("formAlterar") ?
                "Alterar Produto" : "Novo Produto"%></h1>
        
        <%
            Produtos produto = (Produtos) request.getAttribute("produto");
            String acao = (produto == null) ? "incluir" : "alterar";
        %>
        
        <form action="ServletProdutoFC" method="post">
            <input type="hidden" name="acao" value="<%= acao%>">
            
            <%
                if ("alterar".equals(acao)) { %>
                    <input type="hidden" name="id" value="<%= produto.getIDProduto() %>">
            <%  
                }
            %>
            
            <label for="nome">Nome: </label>
            <input type="text" name="nome" id="nome" 
                   value="<%= produto != null ? produto.getNomeProduto() : "" %>" required>
            
            <label for="quantidade">Quantidade: </label>
            <input type="number" name="quantidade" id="quantidade" 
                   value="<%= produto != null ? String.valueOf(produto.getQuantidadeProduto()) : "" %>" required>
            
            <label for="preco">Preço de Venda: </label>
            <input type="number" step="0.01" name="preco" id="preco" 
                   value="<%= produto != null ? String.valueOf(produto.getPrecoVendaBase()) : "" %>" required>
            
            <button type="submit"><%= "alterar".equals(acao) ? "Salvar Alterações" : "Adicionar Produto" %></button>
        </form>
        
    </body>
</html>