package BuisnessLogic;

import java.util.ArrayList;

public class Seccion {
	private String nombre;
	private ArrayList<Componente> componentes;
	
	public Seccion(String nombre, ArrayList<Componente> componentes) {
		super();
		this.nombre = nombre;
		this.componentes = componentes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	
	
	
	
}
