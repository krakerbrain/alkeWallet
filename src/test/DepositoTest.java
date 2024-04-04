package test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import clases.Cuenta;
import clases.Deposito;
import clases.Menu;

public class DepositoTest {

    private Cuenta cuenta;
    private Menu menuMock;

    @Before
    public void setUp() {
        cuenta = new Cuenta();
        menuMock = mock(Menu.class);
    }

    @Test
    public void testDepositar() {
        Deposito deposito = new Deposito(cuenta);
        double monto = 500;

        // Configurar el comportamiento del mock para solicitar datos
        doReturn(monto).when(menuMock).solicitaDatosAUsuario("deposito");

        // Ejecutar la transacción de depósito
        deposito.ejecutarTransaccion(menuMock);

        // Verificar que el saldo se haya actualizado correctamente
        assertEquals(monto, cuenta.getSaldo(), 0.001);

        // Verificar que se llamó al método transaccionExitosa
        verify(menuMock).transaccionExitosa("deposito", monto);
    }
}
