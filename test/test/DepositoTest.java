package test;

import clases.Cuenta;
import clases.Deposito;
import clases.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DepositoTest {

    private static Cuenta cuenta;
    private static Menu menuMock;

    @BeforeAll
    public static void setUp() {
        cuenta = new Cuenta();
        menuMock = Mockito.mock(Menu.class);
    }

    @Test
    public void testDepositar() {
        Deposito deposito = new Deposito(cuenta);
        double monto = 500;

        // Configurar el comportamiento del mock para solicitar datos
        Mockito.doReturn(monto).when(menuMock).solicitaDatosAUsuario("deposito");

        // Ejecutar la transacción de depósito
        deposito.ejecutarTransaccion(menuMock);

        // Verificar que el saldo se haya actualizado correctamente
        Assertions.assertEquals(monto, cuenta.getSaldo(), 0.001);

        // Verificar que se llamó al método transaccionExitosa
        Mockito.verify(menuMock).transaccionExitosa("deposito", monto);
    }
}
