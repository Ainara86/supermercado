package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(
		urlPatterns = { "/home" }, 
		initParams = { 
				@WebInitParam(name = "numeroProductos", value = "10", description = "Numeros de productos a mostrar en la página inicial")
		})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductoArrayListDAO dao;
	private ArrayList<Producto> productos;	
	private Producto productoInicio;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = ProductoArrayListDAO.getInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}

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
		try {
			//String numeroProductos = getSer("numeroProductos");
			String numeroProductos = "10";
			request.setAttribute("numeroProductos", numeroProductos);
			
			//Dao
			//parametros
			String id = request.getParameter("id");
			String op = request.getParameter("op");
			
			//eliminar ?			
			if ( op != null ) {
				dao.delete(id);
			}
			
			//listado videos			
			productos = (ArrayList<Producto>) dao.getAll();
			
			
			//video de inicio
			productoInicio = new Producto();
			if ( id != null ) {
				productoInicio = dao.getById(id);
		
			}else if ( !productos.isEmpty()) {
				productoInicio = productos.get(0);
			}
			
			
			
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

}
