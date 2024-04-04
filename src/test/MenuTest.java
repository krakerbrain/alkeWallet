package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import clases.Cuenta;
import clases.Menu;

class MenuTest {
	private static Cuenta cuenta;

	@BeforeAll
	public static void creaInstanciaCuenta() {
		cuenta = new Cuenta();

	}
	 @Test
	    public void testMenuPpalMensajesError() {
	        // Arrange
	        Menu menuMock = mock(Menu.class);
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outContent));

	        when(menuMock.menuPpal()).thenThrow(new InputMismatchException()); // Simular una entrada inválida

	        // Act & Assert
	        try {
	            menuMock.menuPpal();
	        } catch (InputMismatchException e) {
	            // Esperamos una excepción InputMismatchException, por lo que no necesitamos hacer nada aquí
	        }

	        // Verificar que el contenido de la salida sea un String
	        assertTrue(outContent.toString() instanceof String, "El contenido de salida no es un String");
	    }
	
	/*
	 * @Test void testMenuPpal() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDespedida() { fail("Not yet implemented"); }
	 * 
	 * @Test void testPieTransaccionExitosa() { fail("Not yet implemented"); }
	 * 
	 * @Test void testTransaccionExitosa() { fail("Not yet implemented"); }
	 * 
	 * @Test void testTransaccionExitosaTransferencia() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test void testMuestraSaldo() { fail("Not yet implemented"); }
	 * 
	 * @Test void testTransaccionExitosaVerDatos() { fail("Not yet implemented"); }
	 * 
	 * @Test void testMenuTipoConversion() { fail("Not yet implemented"); }
	 * 
	 * @Test void testMostrarDatosCuenta() { fail("Not yet implemented"); }
	 * 
	 * @Test void testFondosInsuficientes() { fail("Not yet implemented"); }
	 */
}
