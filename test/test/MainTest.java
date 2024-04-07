package test;

import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(rut, cuenta.getRut());
        Assertions.assertEquals(usuario, cuenta.getUsuario());
        Assertions.assertEquals(8, String.valueOf(cuenta.getNroCuenta()).length());
        Assertions.assertEquals(0, cuenta.getSaldo(), 0);
    }

}
