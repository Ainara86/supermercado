package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.List;



public class ProductoArrayListDAO implements CrudAble<Producto> {

	private static ProductoArrayListDAO INSTANCE = null;
	private static List<Producto> productos = null;

	private ProductoArrayListDAO() {
		productos = new ArrayList<Producto>();
		try {
			productos.add(new Producto(1, "Beefeater", 13.35f, 20, null,"ginebra inglesa botella 70cl","18,50€ / Litro"));
			productos.add(new Producto(2, "Absolut Vodka",15.75f, 0, null, "Absolut Vodka es la marca líder de vodka Premium, con el auténtico sabor del vodka original", "19.95€ / Litro"));
			productos.add(new Producto(3, "Don Simón", 1.75f, 0, null, "Vino tinto 12 % vol alcohol. Clarificado y estabilizado. Franco y limpio. Microbiológicamente estable.", "2.15€ / Litro"));
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
		return productos;
	}

	@Override
	public Producto getById(String id) {
		Producto resul = null;
		if (id != null) {
			for (Producto p : productos) {
				if (id.equals(p.getId())) {
					resul = p;
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
		Producto p = null;
		if ( id != null ) { 
			for (int i = 0; i < productos.size(); i++) {
				p = productos.get(i); 
				if (id.equals(p.getId()) ) { 
					resul = productos.remove(p);
					break;
				}
			}
		}	
		return resul;
	}
}

