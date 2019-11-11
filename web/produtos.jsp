<%-- 
    Document   : ProductOrder
    Created on : 10/11/2019, 02:13:44
    Author     : helio
--%>
<%@page import="br.fatecpg.db.Produtos" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf"%>
<div class="container">
    <div class="card mt-5">
        <div class="card-body">
            <h5 class="card-title">Lista de Produtos Fabricante</h5>
            <%if (request.getParameter("i") == null) { %>
            <div>É preciso informar o ID do Fabricante</div>
            <% } else { %>
            <% try { %>
            <% int id = Integer.parseInt(request.getParameter("i"));%>
        
            <table class="table">
                <thead>
                    <tr>
                        <th>
                            ID Fabricante
                        </th>
                        <th>
                            ID Produto
                        </th>
                        <th>
                           Decrição Produto
                        </th>
                        <th>
                            Quantidade em Estoque
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Produtos Lista : Produtos.getList(id)){%>
                        <tr>
                            <td>
                                <%=Lista.getIdFabricante()%>
                            </td>
                            <td>
                                <%=Lista.getIdProduto()%>
                            </td>
                            <td>
                                <%=Lista.getDescricaoProduto()%>
                            </td>
                            <td>
                                <%=Lista.getQtdeEstoque()%>
                            </td>
                        </tr>
                   <%}%>
                </tbody>
            </table>
        </div>
            <%} catch (Exception ex) {%>
                <div class="alert alert-danger" role="alert">
                Erro ao exibir a lista de produtos do fabricante
                </div> 
            <%}%>
            <%}%><br/>
    </div>
</div>    
<%@include file="/WEB-INF/jspf/footer.jspf" %>

