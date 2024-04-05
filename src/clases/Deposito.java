package clases;

//Clase Deposito implementa la interfaz Operacion
public class Deposito implements Operacion {
	// Atributo cuenta para almacenar la cuenta asociada al depósito
	private Cuenta cuenta;
	// Tipo de operación (en este caso, "depósito")
	private String tipoOperacion;

	// Constructor de la clase Deposito que recibe una cuenta como parámetro
	public Deposito(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	// Método ejecutarTransaccion implementado de la interfaz Operacion
	@Override
	public void ejecutarTransaccion(Menu menu) {
		// Establece el tipo de operación como "depósito"
		tipoOperacion = "deposito";
		// Solicita al usuario el monto a depositar utilizando el menú proporcionado
		double monto = menu.solicitaDatosAUsuario(tipoOperacion);
		// Realiza el depósito del monto ingresado en la cuenta
		depositar(monto);
		// Solicita al usuario confirmación de la transacción y obtiene la opción
		// seleccionada
		byte opcion = menu.transaccionExitosa(tipoOperacion, monto);

		// Verifica la opción seleccionada por el usuario
		if (opcion == 1) {
			// Si la opción es 1, permite al usuario seleccionar otra operación en la cuenta
			cuenta.seleccionarOperacion();
		} else {
			// Si la opción es distinta de 1, muestra el mensaje de despedida y finaliza el
			// programa
			menu.despedida();
		}
	}

	// Método para realizar el depósito del monto en la cuenta
	public void depositar(double monto) {
		cuenta.setSaldo(cuenta.getSaldo() + monto); // Aumenta el saldo de la cuenta con el monto depositado
	}
}
