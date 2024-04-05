package clases;

//Clase Retiro que implementa la interfaz Operacion
public class Retiro implements Operacion {

	private Cuenta cuenta; // Referencia a la cuenta sobre la que se realizará el retiro
	private String tipoOperacion; // Tipo de operación, en este caso, retiro

// Constructor de la clase Retiro
	public Retiro(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	// Método para ejecutar la transacción de retiro
	@Override
	public void ejecutarTransaccion(Menu menu) {
		// Se establece el tipo de operación como "retiro"
		tipoOperacion = "retiro";
		// Se solicita al usuario el monto del retiro
		double monto = menu.solicitaDatosAUsuario(tipoOperacion);
		// Se verifica si hay saldo suficiente en la cuenta para realizar el retiro
		if (cuenta.revisaSaldo(monto)) {
			// Si hay saldo suficiente, se realiza el retiro
			retirar(monto);
			// Se muestra un mensaje de transacción exitosa y se ofrece realizar otra
			// operación
			byte opcion = menu.transaccionExitosa(tipoOperacion, monto);
			// Si el usuario desea realizar otra operación, se vuelve al menú principal
			// De lo contrario, se despide al usuario
			if (opcion == 1) {
				cuenta.seleccionarOperacion();
			} else {
				menu.despedida();
			}
		}
	}

	// Método para realizar el retiro del monto especificado
	public void retirar(double monto) {
		// Se reduce el saldo de la cuenta por el monto del retiro
		cuenta.setSaldo(cuenta.getSaldo() - monto);
	}
}
