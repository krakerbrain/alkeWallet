package clases;

//Clase que representa una transacción de transferencia de fondos entre cuentas
public class Transferencia implements Operacion {

	private Cuenta cuenta; // Cuenta desde la cual se realiza la transferencia
	private String tipoOperacion; // Tipo de operación (en este caso, "transferencia")

	// Constructor que recibe la cuenta desde la cual se realizará la transferencia
	public Transferencia(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	// Método para ejecutar una transacción de transferencia
	@Override
	public void ejecutarTransaccion(Menu menu) {
		tipoOperacion = "transferencia"; // Se establece el tipo de operación como "transferencia"
		String cuentaDestino = menu.solicitaCuentaDestino(); // Se solicita el número de cuenta destino
		double monto = menu.solicitaDatosAUsuario(tipoOperacion); // Se solicita el monto a transferir
		// Verifica si hay saldo suficiente en la cuenta
		if (cuenta.revisaSaldo(monto)) {
			transferir(monto); // Se realiza la transferencia de fondos
			byte opcion = menu.transaccionExitosaTransferencia(tipoOperacion, monto, cuentaDestino);
			// Se presenta al usuario la opción de realizar otra operación o salir
			if (opcion == 1) {
				cuenta.seleccionarOperacion(); // Seleccionar otra operación
			} else {
				menu.despedida(); // Despedida
			}
		}
	}

	// Método para realizar la transferencia de fondos
	public void transferir(double monto) {
		cuenta.setSaldo(cuenta.getSaldo() - monto); // Se reduce el saldo de la cuenta origen
	}

}
