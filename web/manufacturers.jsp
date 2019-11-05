<%@page import="br.fatecpg.db.Manufacturer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<div class="card mt-5">
  <div class="card-body">
    <h5 class="card-title">Fabricantes</h5>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Nome
                </th>
                <th>
                    E-mail
                </th>
                <th class="text-center">
                    Ver
                </th>
                <th class="text-center">
                    Editar
                </th>
                <th class="text-center">
                    Excluir
                </th>
            </tr>
        </thead>
        <tbody>
            <%try {
                for(Manufacturer c : Manufacturer.getList()) {%>
                    <tr>
                        <td>
                            <%=c.getId()%>
                        </td>
                        <td>
                            <%=c.getName()%>
                        </td>
                        <td>
                            <%=c.getEmail()%>
                        </td>
                        <td class="text-center">
                            <a href="#" class="btn btn-primary"><i class="fa fa-eye" aria-hidden="true"></i></a>
                        </td>
                        <td class="text-center">
                            <a href="#" class="btn btn-warning"><i class="fa fa-pencil" aria-hidden="true"></i></a>
                        </td>
                        <td class="text-center">
                            <a href="#" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></a>
                        </td>
                    </tr>
                <%}
            } catch(Exception ex) {%>
                <div class="alert alert-danger" role="alert">
                  Erro ao exibir a lista de clientes
                </div>  
            <%}%>
        </tbody>
    </table>
  </div>
</div>
    
<%@include file="/WEB-INF/jspf/footer.jspf" %>