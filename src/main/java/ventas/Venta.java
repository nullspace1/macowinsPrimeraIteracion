package ventas;


import java.time.LocalDate; 
import java.util.HashSet;
import java.util.Set;


public class Venta {
	
	private Set<Compra> prendasAVender;
	private LocalDate fechaDeVenta;
	private Float ganancia = 0f;
	
	public Venta()
	{
		prendasAVender = new HashSet<Compra>();
		fechaDeVenta = LocalDate.now();
	}
	
	public void setGanancia(Float ganancia) {
		this.ganancia = ganancia;
	}
	
	public Float getGanancia() {
		return ganancia;
	}
	
	public LocalDate getFechaDeVenta() {
		return fechaDeVenta;
	}
	
	void agregarPrenda(Prenda nuevaPrenda, Integer cantidad)
	{
		Compra nuevaCompra = new Compra(nuevaPrenda,cantidad);
		prendasAVender.add(nuevaCompra);
	}

	public void  fijarPrecio(MedioDePago medio) {
		// Basicamente transformando la lista de compras en sus totales parciales y despues sumando.
		Float ganancia  = prendasAVender.parallelStream().map((Compra c) -> c.calcularPrecio()).reduce(0f,(Float a,Float b) -> Float.sum(a, b));
		this.ganancia = medio.modificarPrecio(ganancia);
	}
	
	

}
