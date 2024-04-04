package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import alkeWallet.Main;
import clases.Cuenta;

class MainTest {

	@Test
    public void testCreaCuenta() {
        // Arrange
        String rut = "123456789";
        String usuario = "Juan";

        // Act
        Cuenta cuenta = Main.creaCuenta(rut, usuario);

        // Assert
        assertEquals(rut, cuenta.getRut());
        assertEquals(usuario, cuenta.getUsuario());
        assertEquals(8, String.valueOf(cuenta.getNroCuenta()).length());
        assertEquals(0, cuenta.getSaldo(), 0); 
    }

}
