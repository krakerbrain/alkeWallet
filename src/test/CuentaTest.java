package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import clases.Cuenta;
import clases.Menu;
import clases.Operacion;
import clases.TransaccionFactory;

class CuentaTest {
	private static Cuenta cuenta;

	@BeforeAll
	public static void creaInstanciaCuenta() {
		cuenta = new Cuenta();

	}
	
	
	@Test
    public void testConstructor() {
        // Arrange
        String usuario = "Juan Perez";
        String rut = "123456789";
        int nroCuenta = 1001;
        double saldo = 100.0;

        // Act
        Cuenta cuenta = new Cuenta(usuario, rut, nroCuenta, saldo);

        // Assert
        assertEquals(usuario, cuenta.getUsuario());
        assertEquals(rut, cuenta.getRut());
        assertEquals(nroCuenta, cuenta.getNroCuenta());
        assertEquals(saldo, cuenta.getSaldo(), 0.001); // Utilizamos delta para comparar valores dobles
    }
	/**
	 * Se testea que el método generaNumeroCuenta() retorne un número de 8 digitos
	 */

	@Test
	void testGeneraNumeroCuenta() {
		int expected = 8;
		int result = String.valueOf(cuenta.generaNumeroCuenta()).length();
		assertEquals(expected, result);
	}
	
	/*
	 * Este test prueba de forma indirecta el metodo seleccionarOperacion(),
	 * en el cual se ejecuta menuPpal() de la clase Menu la cual devuelve un numero
	 * entre 1 y 6 seleccionado por el usuario, esta opción se le envía como parámetro a 
	 * TransaccionFactory que devuelve la instancia de una clase correspondiente.
	 * La opciones actuales de consulta son 5 por lo cual dentro del for se testea que no devuelva un valor 
	 * nulo 
	 */

	@Test
	public void testObtenerOperacionNoNula() {
		// Arrange
		Menu mockMenu = mock(Menu.class);
		TransaccionFactory transaccionFactory = new TransaccionFactory();

		// Act & Assert
		for (int opcion = 1; opcion <= 5; opcion++) {
			// Simulamos la opción del menú
			when(mockMenu.menuPpal()).thenReturn(opcion);

			// Verificamos si se creó la operación (no importa cuál)
			Operacion operacion = transaccionFactory.obtenerOperacion(cuenta, opcion);
			System.out.println(operacion);
			assertNotEquals(null, operacion);
		}
	}
	
	/*
	 * En este test se aplica el mismo enfoque pero aqui probamos que TransaccionFactorya devuelva null
	 * a la opcion 6. Si esto ocurre en seleccionarOperacion se ejecutará el menú despedida()
	 */

	@Test
	public void testObtenerOperacionSalirMenu() {
		// Arrange
		Menu mockMenu = mock(Menu.class);
		TransaccionFactory transaccionFactory = new TransaccionFactory();

		// Act
		int opcion = 6; // Opción para salir del menú

		// Simulamos la opción del menú
		when(mockMenu.menuPpal()).thenReturn(opcion);

		// Verificamos si se obtiene null para la opción de salir del menú
		Operacion operacion = transaccionFactory.obtenerOperacion(cuenta, opcion);
		
		assertEquals(null, operacion);
	}
	/*
	 * Se testea que el metodo revisaSaldo() devuelva true si el saldo de la cuenta
	 * es mayor al monto de retiro
	 */

	@Test
	public void testRevisaSaldoConSaldoSuficiente() {
		// Arrange
		double saldoFicticio = 100.0;
		cuenta.setSaldo(saldoFicticio); // Establecemos un saldo ficticio suficiente

		// Act
		boolean resultado = cuenta.revisaSaldo(50.0); // Monto menor que el saldo ficticio
		System.out.println(resultado);
		// Assert
		assertTrue(resultado); // Verifica que el resultado sea true
	}
	
	/*
	 * Aqui se testa el método revisaSaldo() con saldo insuficiente, al no tener saldo
	 * se ejecutan dos metodos que estan dentro de la validación, uno de ellos muetra un menú al usuario
	 * por lo cual se implementa doAnswer para emular la respuesta 6 del usuario que sería SALIR
	 * y poder completar el test  
	 */

	@Test
	public void testRevisaSaldoConSaldoInsuficiente() {
		// Arrange
		Cuenta cuentaMock = mock(Cuenta.class);

		double saldoFicticio = 50.0;
		cuenta.setSaldo(saldoFicticio); // Establecemos un saldo ficticio insuficiente

		// Act
		boolean resultado = cuentaMock.revisaSaldo(100.0); // Monto mayor que el saldo ficticio
		Mockito.doAnswer(new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				// Simular la selección de la opción 6 para salir del menú
				System.out.println("Simulando la selección de la opción 6 para salir del menú");
				return 6;
			}
		}).when(cuentaMock).seleccionarOperacion();
		System.out.println(resultado);
		// Assert
		assertFalse(resultado);
	}
}
