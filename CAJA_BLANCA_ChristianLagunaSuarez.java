package examenED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class CAJA_BLANCA_ChristianLagunaSuarez {

	/*-------------Pruebas del metodo procesarPedido de la clase Departamento--------*/
	
	@Test 
	public void pruebaPresupuesto() { //probamos que cumpla el return false ya que excedemos el presupuesto
		Departamento dptoCaro= new Departamento("Finanzas", 10);
		boolean respuesta=dptoCaro.procesarPedido(20);
		assertEquals(false, respuesta);
	}
	@Test
	public void pruebaPresupuestoBuena() { //probamos que cumpla el return true ya que NO excedemos el presupuesto
		Departamento dptoCaro= new Departamento("Marketing", 10);
		boolean respuesta=dptoCaro.procesarPedido(8);
		assertEquals(true, respuesta);
	}
	
	
	
	/*-------------Pruebas del metodo realizarPedido de la clase Instituto--------*/
	
	@Test
	public void pruebaDepartamentoExiste() { //probamos que el departamento con el que queremos realizar el pedido existe en ese instituto
		Instituto monroy = new Instituto(5);
		monroy.agregarDepartamento("RRHH", 500);
		assertTrue(monroy.realizarPedido("RRHH", 30));
	}
	
	@Test
	public void pruebaDeptNoExiste() {  //probamos que el departamento con el que queremos realizar el pedido NO existe en ese instituto
		Instituto monroy = new Instituto(5);
		monroy.agregarDepartamento("Chapa y pintura", 500);
		assertFalse(monroy.realizarPedido("RRHH", 30));
	}
	
	@Test
	public void pruebaDepartamentoExisteNoMoney() { /*probamos que el departamento con el que queremos realizar el pedido existe en ese 
															instituto pero en este caso el monto excede el presupuesto			*/
		
		Instituto monroy = new Instituto(5);
		monroy.agregarDepartamento("RRHH", 50);
		assertFalse(monroy.realizarPedido("RRHH", 600));
	}
	
}
