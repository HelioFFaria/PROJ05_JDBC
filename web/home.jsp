<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/header.jspf" %>

<script>

    function goToPage(url) {
        window.location.href = url;
    }
</script>


<div class="container main">
    <div class="description">
        <div class="title"><h1>Gerencie, controle e analise seu fluxo de produtos</h1></div>
        <p class="text">
            Apresentamos a plataforma web que vai permitir você se conectar e gerenciar seus clientes e fornecedores de maneira simples e rápida. 
            Fornecemos listas que fornecem uma ampla visão a respeito do fluxo de seus produtos
        </p>
        <div class="menu">

            <div class="customer" onclick="goToPage('<%=request.getContextPath()%>/customers.jsp')">
                CLIENTES
            </div>

            <div class="manufacturer" onclick="goToPage('<%=request.getContextPath()%>/manufacturers.jsp')">
                FABRICANTES
            </div>
        </div>
    </div>
    <div class="image">
        <img src="<%=request.getContextPath()%>/res/undraw_data_xmfy.svg"/>
    </div>
</div>
<div class="container-flex team">
    <div class="container">
        <div class="title">
            <h1>CONHEÇA A NOSSA </h1>
            <h1> EQUIPE</h1>
        </div>
        <div class="cards">
            <div class="card">
                <div class="profile"><img src="<%=request.getContextPath()%>/res/images/marina.jpeg" /></div>
                <div class="content">
                    <h4>Marina C. Lopes</h4>
                    <span>Front-end</span>
                </div>
            </div>
            <div class="card">
                <div class="profile"><img src="<%=request.getContextPath()%>/res/images/helio.jpeg" /></div>
                <div class="content">
                    <h4>Hélio F. Faria</h4>
                    <span>Back-end</span>
                </div>
            </div>
        </div>

    </div>

</div>

<%@include file="/WEB-INF/jspf/footer.jspf" %>
