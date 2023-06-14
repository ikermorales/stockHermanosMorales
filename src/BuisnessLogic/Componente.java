package BuisnessLogic;

public class Componente {
	private String id;
	private String nombre;
	private int cantidadActual;
	private int canitdadAvisoMax;
	private int cantidadAvisoMin;
	private float precio;
	private String estanteria;
	private int piso;
	private String balda;
	private String lado;
	private int planta;
	
	
	public Componente(String id, String nombre, int cantidadActual, int canitdadAvisoMax, int cantidadAvisoMin,
			float precio, String estanteria, int piso, String balda, String lado, int planta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidadActual = cantidadActual;
		this.canitdadAvisoMax = canitdadAvisoMax;
		this.cantidadAvisoMin = cantidadAvisoMin;
		this.precio = precio;
		this.estanteria = estanteria;
		this.piso = piso;
		this.balda = balda;
		this.lado = lado;
		this.planta = planta;
	}
	
	
	@Override
	public String toString() {
		return "Componente [id=" + id + ", nombre=" + nombre + ", cantidadActual=" + cantidadActual
				+ ", canitdadAvisoMax=" + canitdadAvisoMax + ", cantidadAvisoMin=" + cantidadAvisoMin + ", precio="
				+ precio + ", estanteria=" + estanteria + ", piso=" + piso + ", balda=" + balda + ", lado=" + lado
				+ ", planta=" + planta + "]";
	}





	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getEstanteria() {
		return estanteria;
	}
	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getBalda() {
		return balda;
	}
	public void setBalda(String balda) {
		this.balda = balda;
	}
	public String getLado() {
		return lado;
	}
	public void setLado(String lado) {
		this.lado = lado;
	}
	public int getPlanta() {
		return planta;
	}
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	
	
	
	
}
