package clases;

import java.util.Scanner;

public class Transferencia implements Operacion {

	Cuenta cuenta;
	String tipoOperacion;

	public Transferencia(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public void ejecutarTransaccion(Menu menu) {
		Scanner scanner = new Scanner(System.in);
		tipoOperacion = "transferencia";
		System.out.println("Ingrese el número de cuenta destino: ");
		String cuentaDestino = scanner.nextLine();
		System.out.println("Ingrese el monto de la " + tipoOperacion + ":");
		double monto = scanner.nextDouble();

		if (cuenta.revisaSaldo(monto)) {
			transferir(monto);
			byte opcion = menu.transaccionExitosaTransferencia(tipoOperacion, monto, cuentaDestino);

			if (opcion == 1) {
				cuenta.seleccionarOperacion();
			} else {
				menu.despedida();
			}
		}
		scanner.close();

	}

	public void transferir(double monto) {
		cuenta.setSaldo(cuenta.getSaldo() - monto);
	}

}