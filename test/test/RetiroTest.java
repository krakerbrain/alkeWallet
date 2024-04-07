package test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import clases.Cuenta;
import clases.Retiro;
import clases.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RetiroTest {
    private static Cuenta cuenta;
    private static Menu menuMock;

	  @BeforeAll
	    public static void setUp() {
	        cuenta = new Cuenta();
	        menuMock = Mockito.mock(Menu.class);
	        cuenta.setSaldo(1000);
	    }

	  @Test
	    public void testEjecutarTransaccion() {

	    	Retiro retiro = new Retiro(cuenta);
	        double monto = 500;

	        // Configurar el comportamiento del mock para solicitar datos
	        Mockito.doReturn(monto).when(menuMock).solicitaDatosAUsuario("retiro");

	        // Ejecutar la transacción de retiro
	        retiro.ejecutarTransaccion(menuMock);

	        // Verificar que el saldo se haya actualizado correctamente
	        Assertions.assertEquals(monto, cuenta.getSaldo(), 0.001);

	        // Verificar que se llamó al método transaccionExitosa
	        Mockito.verify(menuMock).transaccionExitosa("retiro", monto);
	    }

}
