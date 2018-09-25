package com.ipartek.formacion.supermercado.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.supermercado.model.Producto;
import com.ipartek.formacion.supermercado.model.ProductoArrayListDAO;


/**
 * Servlet implementation class ListadoController
 */
@WebServlet("/privado/listado")
public class ListadoController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public static final String OP_ELIMINAR = "1";
	private static ProductoArrayListDAO dao;
	private ArrayList<Producto> productos;	
	private Producto productoInicio;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//Se ejecuta solo con la 1º petición, el resto de peticiones iran a "service"
		dao = ProductoArrayListDAO.getInstance();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		//se ejecuta al parar el servidor
		dao = null;
	}
	
	
	/**
	 * Cada request se ejecuta en un hilo o thread
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		super.service(request, response);  //llama a los metodos GET o POST
				
		//despues de realizar GET o POST
		request.setAttribute("productos", productos);
		request.setAttribute("productoInicio", productoInicio);
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			//parametros
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			
			
			//listado videos			
			productos = (ArrayList<Producto>) dao.getAll();
			
			
			//video de inicio
			productoInicio = new Producto();
			if ( id != null) {
				productoInicio = dao.getById(id);
				
				
			}else if ( !productos.isEmpty()) {
				productoInicio = productos.get(0);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}


}
