package ventas;

public class Tarjeta implements MedioDePago {
	
	private Integer cantidadDeCuotas;
	private Float coeficiente = 0f;
	
	public Tarjeta(Integer cantidadDeCuotas)
	{
		this.cantidadDeCuotas = cantidadDeCuotas;
	}
	
	public void setCoeficiente(Float coeficiente) {
		this.coeficiente = coeficiente;
	}

	@Override
	public Float modificarPrecio(Float total) {
		Float recargo = cantidadDeCuotas * coeficiente + total * 0.01f;
		return total + recargo;
	}
	
	


}
