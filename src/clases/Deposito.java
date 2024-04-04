package clases;

import java.util.Scanner;

public class Deposito implements Operacion {

	Cuenta cuenta;
	String tipoOperacion;

	/**
	 * @param cuenta
	 * @param menu
	 */
	public Deposito(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public void ejecutarTransaccion(Menu menu) {
		Scanner scanner = new Scanner(System.in);
		tipoOperacion = "deposito";

		System.out.println("Ingrese el monto de " + tipoOperacion + ":");
		double monto = scanner.nextDouble();

		depositar(monto);
		byte opcion = menu.transaccionExitosa(tipoOperacion, monto);

		if (opcion == 1) {
			cuenta.seleccionarOperacion();
		} else {
			menu.despedida();
		}
		scanner.close();

	}

	public void depositar(double monto) {
		cuenta.setSaldo(cuenta.getSaldo() + monto);
	}

}
