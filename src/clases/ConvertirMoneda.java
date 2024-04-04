package clases;

//Clase ConvertirMoneda implementa la interfaz Operacion
public class ConvertirMoneda implements Operacion {
	// Atributo cuenta para almacenar la cuenta asociada a la operación
	private Cuenta cuenta;

	// Constructor de la clase ConvertirMoneda que recibe una cuenta como parámetro
	public ConvertirMoneda(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	// Método ejecutarTransaccion implementado de la interfaz Operacion
	@Override
	public void ejecutarTransaccion(Menu menu) {
		// Variable monto inicializada como null para la primera ejecución
		Double monto = null;
		// Llama al método convierteMoneda para realizar la conversión
		convierteMoneda(menu, monto);
	}

	// Método para convertir la moneda
	public void convierteMoneda(Menu menu, Double monto) {
		// Variables para almacenar el monto a convertir y si se convierte un saldo o
		// monto específico
		double montoAConvertir;
		String saldoOMonto;

		// Verifica si el parámetro monto es null para determinar si se debe convertir
		// un saldo o un monto específico
		if (monto != null) {
			montoAConvertir = monto; // Utiliza el monto proporcionado
			saldoOMonto = "MONTO"; // Indica que se está convirtiendo un monto específico
		} else {
			montoAConvertir = cuenta.getSaldo(); // Utiliza el saldo de la cuenta
			saldoOMonto = "SALDO"; // Indica que se está convirtiendo el saldo de la cuenta
		}

		// Crear instancias de cada tipo de moneda con sus tasas de cambio
		Moneda peso = new Moneda("PESO", "CLP ", 1.0, saldoOMonto, montoAConvertir);
		Moneda dolar = new Moneda("DOLAR", "USD ", 979.76, saldoOMonto, montoAConvertir); // Tasa real a reemplazar
		Moneda euro = new Moneda("EURO", "EUR ", 1058.19, saldoOMonto, montoAConvertir); // Tasa real a reemplazar

		Moneda[] arregloMonedas = { peso, dolar, euro };

		// Mostrar la conversión de cada moneda
		for (Moneda moneda : arregloMonedas) {
			moneda.show();
		}

		// Solicitar al usuario el monto a convertir nuevamente si es necesario
		monto = menu.menuTipoConversion();
		// Si el monto no es cero, llamar nuevamente al método para realizar la
		// conversión
		if (monto != 0) {
			convierteMoneda(menu, monto);
		}
	}
}
