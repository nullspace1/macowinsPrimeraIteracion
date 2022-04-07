package ventas;

public class Efectivo implements MedioDePago{

	@Override
	public Float modificarPrecio(Float total) {
		return total;
	}

}
