<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles.css" rel="stylesheet" type="text/css">
        <title>Formulário</title>
    </head>
    <body>
        <div class="container">            
            <form method="post" action="CadastrarUsuarioServlet">

                <h1>Formulário De Cadastro</h1>

                <section class="row">
                    <div> <label>Nome:</label> </div>
                    <div> <input 
                            type="text" 
                            name="nome" 
                            maxlength="150"
                            value="${usuario.nome}" /> 
                    </div>                    
                </section>

                <section class="row">
                    <div> <label>E-mail: </label> </div>
                    <div> <input 
                            type="email"
                            name="email"
                            maxlength="150"
                            value="${usuario.email}" /> 
                    </div>                    
                </section>

                <section class="row">
                    <div> <label>Senha:</label> </div>
                    <div> <input 
                            type="password"
                            name="senha"
                            maxlength="20"
                            value="${usuario.senha}"/> </div>                    
                </section>

                <section class="row">
                    <div> <input class="button" type="submit" value="Salvar"/> </div>                
                </section>

                <c:if test="${not empty erros}">
                    <div class="mensagem">
                        <c:forEach var="erro" items="${erros}">
                            <div class="row">
                                <h2>${erro}</h2> 
                                <div class="separador"></div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${not empty sucesso}">
                    <div class="mensagem">

                        <div class="row">
                            <h2>${sucesso}</h2>                            
                        </div>

                    </div>
                    
                </c:if>

            </form>
        </div>
    </body>
</html>
