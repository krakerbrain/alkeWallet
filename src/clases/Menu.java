package clases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private Scanner scanner;
	private Cuenta cuenta;
	public static final String TEXTO_VERDE = "\u001B[32m";
	public static final String MENSAJE_ERROR = "\u001B[41m\u001B[37m";
	public static final String CERRAR_COLOR = "\u001B[0m";

	public Menu(Cuenta cuenta) {
		this.scanner = new Scanner(System.in);
		this.cuenta = cuenta;
	}

	public int menuPpal() {
		int opcion = 0;
		boolean entradaValida = false;
		do {
			try {
				System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
				System.out.println("¿Qué operación deseas realizar?");
				System.out.println("Seleccione (1) para DEPOSITO");
				System.out.println("Seleccione (2) para RETIRO");
				System.out.println("Seleccione (3) para TRANSFERENCIAS");
				System.out.println("Seleccione (4) para CONVERSOR DE MONEDAS");
				System.out.println("Seleccione (5) para VER DATOS");
				System.out.println("Seleccione (6) para SALIR");
				System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
				opcion = scanner.nextInt();
	            if (opcion < 1 || opcion > 6) {
	                System.out.println(MENSAJE_ERROR + "Error: Opción inválida. Por favor, seleccione una opción válida." + CERRAR_COLOR);
	                continue; // Volver al inicio del bucle para solicitar una nueva entrada
	            }
				entradaValida = true;
			} catch (InputMismatchException e) {
				// Limpiar el buffer del scanner
				scanner.nextLine();
				System.out.println(MENSAJE_ERROR + "Error: Por favor, ingrese un número entero válido." + CERRAR_COLOR);
			}
		} while (!entradaValida || opcion < 1 || opcion > 6);
		return opcion;
	}

	public void despedida() {
		System.out.println(TEXTO_VERDE + "Gracias por usar ALKEMY WALLET");
		System.out.println("********Vuelve pronto*********" + CERRAR_COLOR);
	}

	public byte pieTransaccionExitosa() {
		byte opcion = 0;
		boolean entradaValida = false;
		do {
			try {
				System.out.println("¿Desea realizar otra operación?");
				System.out.println("Seleccione (1) para SI");
				System.out.println("Seleccione (2) para TERMINAR Y SALIR");
				opcion = scanner.nextByte();
				if (opcion < 1 || opcion > 2) {
					System.out.println(
							TEXTO_VERDE + "Error: Por favor, seleccione una opción válida (1 o 2)." + CERRAR_COLOR);
					continue; // Volver al inicio del bucle
				}
				entradaValida = true;
			} catch (InputMismatchException e) {
				// Limpiar el buffer del scanner
				scanner.nextLine();
				System.out.println(TEXTO_VERDE + "Error: Por favor, ingrese un número entero válido." + CERRAR_COLOR);
			}
		} while (!entradaValida);
		return opcion;
	}

	public byte transaccionExitosa(String operacion, double monto) {
		System.out.println(TEXTO_VERDE + "******TRANSACCION EXITOSA******" + CERRAR_COLOR);
		System.out.println("Se ha realizado un " + operacion);
		System.out.println("En la cuenta: " + cuenta.getNroCuenta());
		System.out.println("Del usuario: " + cuenta.getUsuario());
		System.out.println("Por un monto de: $" + monto);
		muestraSaldo();
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
		return pieTransaccionExitosa();
	}

	public byte transaccionExitosaTransferencia(String operacion, double monto, String cuentaDestino) {
		System.out.println(TEXTO_VERDE + "******TRANSACCION EXITOSA******" + CERRAR_COLOR);
		System.out.println("Se ha realizado una " + operacion + " a la cuenta " + cuentaDestino + " por: $" + monto);
		System.out.println("Desde la cuenta: " + cuenta.getNroCuenta() + " de: " + cuenta.getUsuario());
		muestraSaldo();
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
		return pieTransaccionExitosa();
	}

	public void muestraSaldo() {
		System.out.println("SALDO ACTUAL: $" + cuenta.getSaldo() + "\u001B[0m");
	}

	public byte transaccionExitosaVerDatos() {
		return pieTransaccionExitosa();
	}

	public double menuTipoConversion() {
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
		System.out.println("DESEA CONVERTIR UN MONTO DISTINTO?:");
		System.out.println("Seleccione (1) para SI");
		System.out.println("Seleccione (2) para IR AL MENU INICIAL");
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
		byte opcion = scanner.nextByte();

		if (opcion == 1) {
			System.out.println("Escriba el monto que desea convertir:");
			double monto = scanner.nextDouble();
			return monto;
		} else {
			cuenta.seleccionarOperacion();
			return 0;
		}
	}

	public void mostrarDatosCuenta() {
		System.out.println(TEXTO_VERDE + "******DATOS DE LA CUENTA******" + CERRAR_COLOR);
		System.out.println("Nombre usuario: " + cuenta.getUsuario());
		System.out.println("RUT: " + cuenta.getRut());
		System.out.println("Número de cuenta: " + cuenta.getNroCuenta());
		System.out.println("Saldo actual: $" + cuenta.getSaldo());
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
	}

	public void fondosInsuficientes() {
		System.err.println(MENSAJE_ERROR + "Error: Fondos insuficientes");
		System.out.println("Su saldo actual es de: " + cuenta.getSaldo());
		System.out.println("Debe realizar un depósito o seleccionar otra operación" + CERRAR_COLOR);
	}

}
