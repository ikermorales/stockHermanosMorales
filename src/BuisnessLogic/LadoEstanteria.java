package BuisnessLogic;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.AttributeList;
import javax.swing.JPanel;

public class LadoEstanteria extends Estanteria {
	private static char pisosMaximos;
	private int baldasMaximas;
	private ArrayList<Seccion> secciones;



	public LadoEstanteria(int planta, String nombre, char pisosMaximos, int baldasMaximas, ArrayList<Seccion> secciones) {
		super(planta, nombre);
		this.pisosMaximos = pisosMaximos;
		this.baldasMaximas = baldasMaximas;
		this.secciones = secciones;
	}


	public char getPisosMaximos() {
		return pisosMaximos;
	}


	public void setPisosMaximos(char pisosMaximos) {
		this.pisosMaximos = pisosMaximos;
	}


	public int getBaldasMaximas() {
		return baldasMaximas;
	}


	public void setBaldasMaximos(int baldasMaximas) {
		this.baldasMaximas = baldasMaximas;
	}


	public ArrayList<Seccion> getSecciones() {
		return secciones;
	}


	public void setSecciones(ArrayList<Seccion> secciones) {
		this.secciones = secciones;
	}

	public void construirSecciones() {

		secciones = new ArrayList<>();
		ArrayList<String> letras = new ArrayList<>();
		
		letras.add("Superior");
		for (char c = 'A'; c <= pisosMaximos; c++) {
			letras.add(String.valueOf(c));
		}
		letras.add("Suelo");

		for (int i = 1; i <= baldasMaximas; i++) {
			for (String string : letras) {
				String nombre = string + i ; 
				secciones.add(new Seccion(nombre , new ArrayList<>()));
			}

		}


	}



}
