package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ipartek.formacion.supermercado.model.Usuario;
import com.ipartek.formacion.supermercado.model.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alert alert = new Alert();
		HttpSession session = request.getSession();
		
		try {
			//recoger parametros
			String usuarioNombre = request.getParameter("usuario");
			String pass = request.getParameter("pass");
				
			//comprobar usuario TODO contra BBDD
			if ( "admin".equals(pass) && "admin".equals(usuarioNombre)  )  {
				
				alert.setTexto("Bienvenido");
				alert.setTipo(Alert.PRIMARY);
				
				//guardar Usuario en session
				Usuario u = new Usuario(usuarioNombre, pass);
				
				session.setAttribute("usuario", u);
				session.setMaxInactiveInterval(60); // 1min
				
				
	
			}else{
				
				alert.setTexto("Credenciales incorrectas" );
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.setAttribute("alert", alert);
			//request.getRequestDispatcher("home.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "login.jsp" ); 
		}
		
	}

}
