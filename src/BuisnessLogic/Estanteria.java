package BuisnessLogic;

public abstract class Estanteria{
	private int planta;
	private String nombre;
	
	public Estanteria(int planta, String nombre) {
		super();
		this.planta = planta;
		this.nombre = nombre;
	}
	public int getPlanta() {
		return planta;
	}
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
