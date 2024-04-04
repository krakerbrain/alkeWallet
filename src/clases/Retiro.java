package clases;

import java.util.Scanner;

public class Retiro implements Operacion {

	Cuenta cuenta;
	String tipoOperacion;

	/**
	 * @param menu
	 */
	public Retiro(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public void ejecutarTransaccion(Menu menu) {
		Scanner scanner = new Scanner(System.in);
		tipoOperacion = "retiro";

		System.out.println("Ingrese el monto de " + tipoOperacion + ":");
		double monto = scanner.nextDouble();

		if (cuenta.revisaSaldo(monto)) {
			retirar(monto);
			byte opcion = menu.transaccionExitosa(tipoOperacion, monto);

			if (opcion == 1) {
				cuenta.seleccionarOperacion();
			} else {
				menu.despedida();
			}
		}
		scanner.close();

	}

	/*
	 * HAy que revisar porque al salir me devuelve el menu de transaccion exitosa
	 */
	public void retirar(double monto) {
		cuenta.setSaldo(cuenta.getSaldo() - monto);
	}
}
