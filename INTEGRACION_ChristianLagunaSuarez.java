package examenED;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class INTEGRACION_ChristianLagunaSuarez {
	
	@Test
	public void pruebaPedido() { /*probamos la integracion del instituto con los departamentos a la hora de realizar
	 							pedidos tanto el departamento como el monto son correctos asi que deberia devolver true*/
		Instituto cristobal = new Instituto(5);
		cristobal.agregarDepartamento("IT", 500);
		assertTrue(cristobal.realizarPedido("IT", 5));
	}
	
}
