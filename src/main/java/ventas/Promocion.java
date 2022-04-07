package ventas;

public class Promocion implements Estado {

	private Float descuento;
	
	public Promocion(Float descuento)
	{
		this.descuento = descuento;
	}
	
	public Float getDescuento() {
		return descuento;
	}
	
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	@Override
	public Float modificar(Float precio) {
		return precio - descuento;
	}

}
