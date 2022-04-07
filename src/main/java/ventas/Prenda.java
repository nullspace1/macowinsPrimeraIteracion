package ventas;

public class Prenda {
	
	private String idPrenda;
	private Float precioBase;
	private Estado estado;
	private TipoPrenda tipoPrenda;
	
	
	public Prenda(String idPrenda,Float precioBase, Estado estado, TipoPrenda tipoPrenda)
	{
		this.estado = estado;
		this.idPrenda = idPrenda;
		this.precioBase = precioBase;
		this.tipoPrenda = tipoPrenda;
	}
	
	public TipoPrenda getTipoPrenda() {
		return tipoPrenda;
	}
	
	public String getIdPrenda() {
		return idPrenda;
	}
	
	public float calcularPrecio()
	{
		return estado.modificar(precioBase);
	}

}
