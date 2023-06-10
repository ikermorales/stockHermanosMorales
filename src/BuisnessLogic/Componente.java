package BuisnessLogic;

public class Componente {
	private String id;
	private int cantidadActual;
	private int canitdadAvisoMax;
	private int cantidadAvisoMin;
	private float precio;
	
	
	public Componente(String id, int cantidadActual, int canitdadAvisoMax, int cantidadAvisoMin, float precio) {
		super();
		this.id = id;
		this.cantidadActual = cantidadActual;
		this.canitdadAvisoMax = canitdadAvisoMax;
		this.cantidadAvisoMin = cantidadAvisoMin;
		this.precio = precio;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getCantidadActual() {
		return cantidadActual;
	}


	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}


	public int getCanitdadAvisoMax() {
		return canitdadAvisoMax;
	}


	public void setCanitdadAvisoMax(int canitdadAvisoMax) {
		this.canitdadAvisoMax = canitdadAvisoMax;
	}


	public int getCantidadAvisoMin() {
		return cantidadAvisoMin;
	}


	public void setCantidadAvisoMin(int cantidadAvisoMin) {
		this.cantidadAvisoMin = cantidadAvisoMin;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
	
	
}
