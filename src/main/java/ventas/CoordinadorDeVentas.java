/**
 * 
 */
package ventas;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author Lautaro
 *
 */

public class CoordinadorDeVentas {
	
	private Set<Prenda> ropaDelLocal;
	private List<Venta> ventasRealizadas;
	
	public Prenda consultarPrenda(String Id) throws NoSuchElementException
	{
		Optional<Prenda> resultado = ropaDelLocal.stream().filter((Prenda p) -> p.getIdPrenda() == Id).findFirst();
		if (resultado.isPresent())
		{
			return resultado.get();
		}
		else
		{
			throw new NoSuchElementException("No existe prenda con ese ID!");
		}
	}
	
	public Float consultarGananicasEn(LocalDate fecha)
	{
		Stream<Venta> ventasEnFecha = ventasRealizadas.stream().filter((Venta v) -> (v.getFechaDeVenta() == fecha));
		return ventasEnFecha.map((Venta v) -> v.getGanancia()).reduce(0f, (a,b) -> Float.sum(a,b));
	}
	
	public Venta iniciarVenta()
	{
		return new Venta();
	}
	
	public void concretarVenta(Venta venta, MedioDePago medio)
	{
		venta.fijarPrecio(medio);
		ventasRealizadas.add(venta);
	}

}
