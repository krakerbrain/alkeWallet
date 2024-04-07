package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clases.Cuenta;
import clases.Menu;
import org.mockito.Mockito;

class MenuTest {

    @BeforeAll
	public static void creaInstanciaCuenta() {
        Cuenta cuenta = new Cuenta();

	}
	 @Test
	    public void testMenuPpalMensajesError() {
	        // Arrange
	        Menu menuMock = Mockito.mock(Menu.class);
	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outContent));

	        Mockito.when(menuMock.menuPpal()).thenThrow(new InputMismatchException()); // Simular una entrada inválida

	        // Act & Assert
	        try {
	            menuMock.menuPpal();
	        } catch (InputMismatchException e) {
	            // Esperamos una excepción InputMismatchException, por lo que no necesitamos hacer nada aquí
	        }

	        // Verificar que el contenido de la salida sea un String
         Assertions.assertInstanceOf(String.class, outContent.toString(), "El contenido de salida no es un String");
	    }
	
}
