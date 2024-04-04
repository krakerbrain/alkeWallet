package test;

import static org.junit.Assert.*;
import org.junit.Test;

import clases.Cuenta;
import clases.Deposito;
import clases.Menu;

import org.junit.Before;
import org.junit.After;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class DepositoTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testDepositar() {
        Cuenta cuenta = new Cuenta(); // Aquí debes inicializar correctamente una cuenta
        Deposito deposito = new Deposito(cuenta);
        deposito.depositar(100.0); // Realizar depósito de $100
        assertEquals(100.0, cuenta.getSaldo(), 0.01); // Verificar que el saldo sea 100.0
    }

    @Test
    public void testEjecutarTransaccion() {
        // Preparar datos de prueba
        String input = "100\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Ejecutar método bajo prueba
        Cuenta cuenta = new Cuenta(); // Aquí debes inicializar correctamente una cuenta
        Deposito deposito = new Deposito(cuenta);
        Menu menu = new Menu(cuenta); // Debes inicializar correctamente un menú
        deposito.ejecutarTransaccion(menu);

        // Verificar resultados
        assertEquals("Ingrese el monto de deposito:\n", outContent.toString());
        assertTrue(outContent.toString().contains("Transacción exitosa: deposito de $100.0\n"));
        // Verificar que el saldo se actualizó correctamente
        assertEquals(100.0, cuenta.getSaldo(), 0.01);
    }
}
