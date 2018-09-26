package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductoArrayListDAO implements CrudAble<Producto> {

	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;
	private boolean chivato = false;

	private ProductoArrayListDAO() {
		productos = new ArrayList<Producto>();
		try {
			productos.add(new Producto(0120, "Vodka", 18, 0, "images/default_product.png", "18€/L", "barato"));
			productos.add(new Producto(0121, "Ginebra", 18, 50, "images/default_product.png", "12€/L", "caro"));
			productos.add(new Producto(0121, "Beefeater", 18, 15, "images/default_product.png", "14€/L", "malo"));
			productos.add(new Producto(0121, "Ron", 18, 75, "images/default_product.png", "16€/L", "baratisimo"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized ProductoArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProductoArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Producto pojo) {
		return productos.add(pojo);
	}

	@Override
	public List<Producto> getAll() {
		if(!chivato) {
			Collections.reverse(productos);
			chivato = true;
		}
		return productos;
	}

	@Override
	public Producto getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Producto getById(Long id) {
		Producto resul = null;
		if (id != null) {
			for (Producto v : productos) {
				if (id == v.getId()) {
					resul = v;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Producto pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Producto v = null;
		if ( id != null ) { 
			for (int i = 0; i < productos.size(); i++) {
				v = productos.get(i); 
				if (id.equals(v.getId()) ) { 
					resul = productos.remove(v);
					break;
				}
			}
		}	
		return resul;
	}

}