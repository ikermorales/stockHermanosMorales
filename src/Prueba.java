import java.util.ArrayList;

import BuisnessLogic.LadoEstanteria;
import BuisnessLogic.Seccion;
import GUI.PanelPlantaUno;
import GUI.VentanaPrincipal;

public class Prueba {
	public static void main(String[] args) {
		
		VentanaPrincipal ventanaMain = new VentanaPrincipal();


		
		//LadoEstanteria rodamientos = new LadoEstanteria(1,"Rodamientos",'A',1, new ArrayList<>());
		//rodamientos.construirSecciones();
		
		LadoEstanteria electricidadUno = new LadoEstanteria(2,"Electricidad 1",'F',1, new ArrayList<>());
		electricidadUno.construirSecciones();
		
		LadoEstanteria electricidadDos = new LadoEstanteria(2,"Electricidad 2",'C',1, new ArrayList<>());
		electricidadDos.construirSecciones();
		
		LadoEstanteria fluorescentes = new LadoEstanteria(2,"Fluorescentes",'C',3, new ArrayList<>());
		fluorescentes.construirSecciones();
		
		LadoEstanteria bombillas = new LadoEstanteria(2,"Bombillas",'L',1, new ArrayList<>());
		bombillas.construirSecciones();
		
		LadoEstanteria variadosCuatro = new LadoEstanteria(2,"Varios 4",'L',1, new ArrayList<>());
		variadosCuatro.construirSecciones();
		
		
		
	
	}
}
