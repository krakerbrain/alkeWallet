package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import clases.Cuenta;
import clases.Retiro;
import clases.Menu;

public class RetiroTest {
    private Cuenta cuenta;
    private Menu menuMock;

	  @Before
	    public void setUp() {
	        cuenta = new Cuenta();
	        menuMock = mock(Menu.class);
	        cuenta.setSaldo(1000);
	    }

	  @Test
	    public void testEjecutarTransaccion() {

	    	Retiro retiro = new Retiro(cuenta);
	        double monto = 500;

	        // Configurar el comportamiento del mock para solicitar datos
	        doReturn(monto).when(menuMock).solicitaDatosAUsuario("retiro");

	        // Ejecutar la transacción de retiro
	        retiro.ejecutarTransaccion(menuMock);

	        // Verificar que el saldo se haya actualizado correctamente
	        assertEquals(monto, cuenta.getSaldo(), 0.001);

	        // Verificar que se llamó al método transaccionExitosa
	        verify(menuMock).transaccionExitosa("retiro", monto);
	    }

}
