package ventas;

public class Compra {
	
	private Prenda prenda;
	private Integer cantidad;
	
	public Compra(Prenda prenda, Integer cantidad)
	{
		this.prenda = prenda;
		this.cantidad = cantidad;
	}
	
	public Float calcularPrecio()
	{
		return prenda.calcularPrecio() * cantidad;
 	}

}
