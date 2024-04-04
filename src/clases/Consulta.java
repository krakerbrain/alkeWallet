package clases;

public class Consulta implements Operacion {
	private Cuenta cuenta;

	public Consulta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public void ejecutarTransaccion(Menu menu) {
		menu.mostrarDatosCuenta();
		byte opcion = menu.pieTransaccionExitosa();

		if (opcion == 1) {
			cuenta.seleccionarOperacion();
		} else {
			menu.despedida();
		}
	}

}
