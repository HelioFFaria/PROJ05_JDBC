<%-- 
    Document   : ProductOrder
    Created on : 10/11/2019, 02:13:44
    Author     : helio
--%>
<%@page import="br.fatecpg.db.productOrder" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf"%>
<div class="card mt-5">
    <div class="card-body">
        <h5 class="card-title">Lista de Compras Cliente</h5>
        <h3>Cliente ID</h3>
        <%if(request.getParameter("i")==null){ %>
                    <div>É preciso informar o ID do Cliente</div>
                <% } else { %>
                    <% try { %>
                        <% int i = Integer.parseInt(request.getParameter("i")); %>
                        <% productOrder Order = productOrder.getList().get(i); %>
                       <h4><%= Order.getIdCliente()%></h4>
                       <br/><br/> 
    </div>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>
                                        ID Cliente
                                    </th>
                                    <th>
                                        ID Ordem de Compra
                                    </th>
                                    <th>
                                        Data de Compra
                                    </th>
                                    <th>
                                        Quantidade
                                    </th>
                                    <th>
                                        ID Produto
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <%=Order.getIdCliente()%>
                                    </td>
                                    <td>
                                        <%=Order.getIdOrdemCompra()%>
                                    </td>
                                    <td>
                                        <%=Order.getDataCompra()%>
                                    </td>
                                    <td>
                                        <%=Order.getQtdeOrdemCompra()%>
                                    </td>
                                    <td>
                                        <%=Order.getIdProduto()%>
                                    </td>
                                </tr>
                            </tbody>
                        </table>    
                    <%} catch(Exception ex) {%>
                        <div class="alert alert-danger" role="alert">
                          Erro ao exibir a lista de compra do cliente
                        </div>  
                    <%}%>
                <%}%><br/>
</div>
    
<%@include file="/WEB-INF/jspf/footer.jspf" %>
