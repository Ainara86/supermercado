<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

        <main role="main" class="container">
        
        <p class="text-danger">${param.msg }</p>

       	<p class="text-danger">${param.usuario }</p>
       	<p class="text-danger">${param.pass }</p>

            <div class="row justify-content-center">
                <h1 class="col col-md-6"><i class="fas fa-user"></i> Login</h1>
            </div>
                    
            <div class="row justify-content-center">
                <small id="login-small" class="col col-md-6">Los campos con * son obligatorios</small>
            </div>

            <form id="login-form">
			
                <div class="form-row justify-content-center">
                            
                    <div class="col col-md-6">
                        
                        <div class="form-group">
                            <label for=email class="required">Email</label>
                            <input name="usuario" class="form-control" type="text" placeholder="Ej: paco@gmail.com" autofocus >
                        </div>
                                    
                        <div class="form-group">
                            <label for="pass" class="required">Contraseña</label>
                        	<input name="pass" class="form-control" type="password" placeholder="Contraseña del usuario (8 a 20 caracteres)">
                        </div>
                                    
                        <button type="submit" class="btn btn-outline-primary btn-block">Acceder</button>
                                    
                    </div>
                                    
                </div>
                            
            </form>

        </main>

<%@include file="includes/footer.jsp" %>