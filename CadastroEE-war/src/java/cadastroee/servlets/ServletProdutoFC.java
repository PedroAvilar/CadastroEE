/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import cadastroee.controller.ProdutosFacadeLocal;
import java.util.List;
import cadastroee.model.Produtos;
import jakarta.servlet.RequestDispatcher;

/**
 *
 * @author pedro
 */
public class ServletProdutoFC extends HttpServlet {
    
    @EJB
    ProdutosFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino;

        if ("formIncluir".equals(acao) || "formAlterar".equals(acao)) {
            destino = "Produtos.jsp";
        } else {
            destino = "ProdutosLista.jsp";
        }
        
        try {
            switch (acao) {
                case "listar": {
                    List<Produtos> produtos = facade.findAll();
                    request.setAttribute("produtos", produtos);
                    break;
                }
                case "formAlterar": {
                    int idAlterar = Integer.parseInt(request.getParameter("id"));
                    Produtos produtoAlterar = facade.find(idAlterar);
                    request.setAttribute("produto", produtoAlterar);
                    break;
                }
                case "excluir": {
                    int idExcluir = Integer.parseInt(request.getParameter("id"));
                    Produtos produtoExcluir = facade.find(idExcluir);
                    facade.remove(produtoExcluir);
                    request.setAttribute("produtos", facade.findAll());
                    break;
                }
                case "alterar": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Produtos produtoAlterado = facade.find(id);
                    produtoAlterado.setNomeProduto(request.getParameter("nome"));
                    produtoAlterado.setPrecoVendaBase(Float.valueOf(request.getParameter("preco")));
                    facade.edit(produtoAlterado);
                    request.setAttribute("produtos", facade.findAll());
                    break;
                }
                case "incluir": {
                    Produtos novoProduto = new Produtos();
                    novoProduto.setNomeProduto(request.getParameter("nome"));
                    novoProduto.setNomeProduto(request.getParameter("quantidade"));
                    novoProduto.setPrecoVendaBase(Float.valueOf(request.getParameter("preco")));
                    facade.create(novoProduto);
                    request.setAttribute("produtos", facade.findAll());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
