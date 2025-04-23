package examenED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class CAJA_NEGRA_ChristianLagunaSuarez {
	
	@Test
	public void pruebaMontoIgualPrespuesto() { /*prueba para verificar que solo el metodo de procesarPedido da FALSE
	 								cuando el monto excede el presupuesto, si son iguales el pedido deberia realizarse sin problema*/
		Departamento dpto2 = new Departamento("IT", 3);
		assertTrue(dpto2.procesarPedido(3));
	}
	
	@Test
	public void pruebaPresupuestoMaximoValor() { //prueba para verificar que el presupuesto puede ser el maximo valor posible sin problema
		Departamento dpto = new Departamento("IT", Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, dpto.getPresupuesto());
	}
	@Test
	public void pruebaPresupuestoMinimoValor() { //prueba para verificar que el presupuesto puede ser el minimo valor posible sin problema
		Departamento dpto = new Departamento("IT", Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, dpto.getPresupuesto());
	}
	
	@Test 
	public void pruebaPresptoNegMontoPositivo() { //prueba que deberia dar false ya que -5 es menor que 10 pero se aceptan valores negativos como presupuesto
		Departamento dpto2 = new Departamento("IT", -5);
		assertFalse(dpto2.procesarPedido(10));
	}
	
	@Test 
	public void pruebaPresptoPosMontoNeg() { //prueba que deberia dar true ya que 10 es mayor que -5 pero se aceptan valores negativos como monto
		Departamento dpto2 = new Departamento("IT", 10);
		assertTrue(dpto2.procesarPedido(-5));
	}
	@Test 
	public void pruebaAmbosNegativos() { /*prueba en la que ambos numeros son negativos e iguales, se realiza el proceso y devuelve 
										true porque se cumple que el monto NO es mayor que el presupuesto aunque ambos sean negativos*/
		Departamento dpto2 = new Departamento("IT", -5);
		assertTrue(dpto2.procesarPedido(-5));
	}
	
	@Test
	public void pruebaDesbordamiento() { /*prueba para desbordamiento ya que el metodo de procesarPedido siempre resta 
									y en este caso va a hacer una resta al numero minimo posible*/
		Departamento dpto = new Departamento("IT", Integer.MIN_VALUE);
		dpto.procesarPedido(1); //este metodo devuelve un boolean por eso uso abajo el de getPresupuesto
		assertThrows(ArithmeticException.class, () -> dpto.getPresupuesto(), "No hay desbordamiento al restar");
	}
	
	
}
