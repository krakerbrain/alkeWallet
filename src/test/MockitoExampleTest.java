package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import clases.Menu;

class MockitoExampleTest {
	  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	  private final PrintStream originalOut = System.out;
	  private Menu menuMock;
	  
	 @BeforeEach
	    public void setUpStreams() {
	        System.setOut(new PrintStream(outContent));
	        menuMock = mock(Menu.class);
	    }

	    @AfterEach
	    public void restoreStreams() {
	        System.setOut(originalOut);
	    }

	 @Test
	    void testMenuPpal_OpcionInvalida() {
	        // Configurar el comportamiento del mock para que devuelva 7 (opción inválida)
	        when(menuMock.menuPpal()).thenReturn(7);

	        // Llamar al método que queremos probar
	        menuMock.menuPpal();

	        // Verificar que se imprime el mensaje de error
	        assertTrue(outContent.toString().contains("Opción inválida. Selecciona una opción del 1 al 6."));
	    }
	}


