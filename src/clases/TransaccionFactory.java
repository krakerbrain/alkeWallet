package clases;

public class TransaccionFactory {

	/**
	 * Método para obtener una instancia de una operación bancaria basada en la
	 * opción dada por el usuario.
	 *
	 * @param cuenta Instancia de la cuenta sobre la cual se realizará la operación.
	 * @param opcion Opción seleccionada por el usuario para determinar el tipo de
	 *               operación.
	 * @return Instancia de la operación correspondiente o null si la opción es
	 *         inválida.
	 */
	public Operacion obtenerOperacion(Cuenta cuenta, int opcion) {
		switch (opcion) {
		case 1:
			return new Deposito(cuenta); // Devuelve una instancia de la operación de depósito.
		case 2:
			return new Retiro(cuenta); // Devuelve una instancia de la operación de retiro.
		case 3:
			return new Transferencia(cuenta); // Devuelve una instancia de la operación de transferencia.
		case 4:
			return new ConvertirMoneda(cuenta); // Devuelve una instancia de la operación de conversión de moneda.
		case 5:
			return new Consulta(cuenta); // Devuelve una instancia de la operación de consulta.
		default:
			return null; // Devuelve null si la opción no es válida.
		}
	}

}
