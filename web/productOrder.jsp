<%-- 
    Document   : ProductOrder
    Created on : 10/11/2019, 02:13:44
    Author     : helio
--%>
<%@page import="br.fatecpg.db.productOrder" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf"%>
<div class="container">
    <div class="card mt-5">
        <div class="card-body">
            <h5 class="card-title">Lista de Compras Cliente</h5>
            <%if (request.getParameter("i") == null) { %>
            <div>É preciso informar o ID do Cliente</div>
            <% } else { %>
            <% try { %>
            <% int id = Integer.parseInt(request.getParameter("i")); %>
        
            <table class="table">
                <thead>
                    <tr>
                        <th>
                            ID Cliente
                        </th>
                        <th>
                            ID Ordem de Compra
                        </th>
                        <th>
                            ID Produto
                        </th>
                        <th>
                            Quantidade
                        </th>
                        <th>
                            Data de Compra
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <% for( productOrder Order : productOrder.getList(id)){%>
                        <tr>
                            <td>
                                <%=Order.getIdCliente()%>
                            </td>
                            <td>
                                <%=Order.getIdOrdemCompra()%>
                            </td>
                            <td>
                                <%=Order.getIdProduto()%>
                            </td>
                            <td>
                                <%=Order.getQtdeOrdemCompra()%>
                            </td>
                            <td>
                                <%=Order.getDataCompra()%>
                             </td>
                        </tr>
                   <%}%>
                </tbody>
            </table>
        </div>
        <%} catch (Exception ex) {%>
        <div class="alert alert-danger" role="alert">
            Erro ao exibir a lista de compra do cliente
        </div>  
        <%}%>
        <%}%><br/>
    </div>
</div>    
<%@include file="/WEB-INF/jspf/footer.jspf" %>
