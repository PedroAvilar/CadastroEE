<%-- 
    Document   : ProdutoLista
    Created on : 29 de out. de 2024, 18:24:52
    Author     : pedro
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    
    <body>
        <h1>Listagem de Produtos</h1>
        
        <a href="ServletProdutoFC?acao=formIncluir">Novo Produto</a>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço de Venda</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<cadastroee.model.Produtos> produtos = 
                            (List<cadastroee.model.Produtos>) request.getAttribute("produtos");
                    if (produtos != null) {
                        for (cadastroee.model.Produtos produto : produtos) {
                %>            
                            <tr>
                                <td><%= produto.getIDProduto() %></td>
                                <td><%= produto.getNomeProduto() %></td>
                                <td><%= produto.getQuantidadeProduto() %></td>
                                <td>R$ <%= produto.getPrecoVendaBase() %></td>
                                <td>
                                    <a href="ServletProdutoFC?acao=formAlterar&id=<%= produto.getIDProduto() %>">Alterar</a> |
                                    <a href="ServletProdutoFC?acao=excluir&id=<%= produto.getIDProduto() %>" 
                                       onclick="return confirm('Tem certeza que deseja excluir este produto?');">Excluir</a>
                                </td>
                            </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="5">Nenhum produto disponível.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
