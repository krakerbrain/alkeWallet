package clases;

import java.util.InputMismatchException;
import java.util.Scanner;

// Clase Menu para interactuar con el usuario y mostrar información
public class Menu {
	// Scanner para leer la entrada del usuario
	private Scanner scanner;
	// Cuenta asociada al menú
	private Cuenta cuenta;
	// Cadenas de colores para mejorar la presentación en la consola
	private String TEXTO_VERDE = "\u001B[32m";
	private String MENSAJE_ERROR = "\u001B[41m\u001B[37m";
	private String CERRAR_COLOR = "\u001B[0m";

	// Constructor que recibe una cuenta como parámetro
	public Menu(Cuenta cuenta) {
		this.scanner = new Scanner(System.in);
		this.cuenta = cuenta;
	}

	// Método para mostrar el menú principal y obtener la opción seleccionada
	public int menuPpal() {
		int opcion = 0;
		boolean entradaValida = false;
		// Ciclo do-while para validar la entrada del usuario
		do {
			try {
				// Mostrar opciones del menú principal
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
				// Validar que la opción esté dentro del rango válido
				if (opcion < 1 || opcion > 6) {
					System.out.println(MENSAJE_ERROR
							+ "Error: Opción inválida. Por favor, seleccione una opción válida." + CERRAR_COLOR);
					continue; // Volver al inicio del bucle para solicitar una nueva entrada
				}
				entradaValida = true;
			} catch (InputMismatchException e) {
				// Limpiar el buffer del scanner
				scanner.nextLine();
				mensajeDeError("número entero");
			}
		} while (!entradaValida || opcion < 1 || opcion > 6);
		return opcion;
	}

	// Método para mostrar el mensaje de despedida al usuario
	public void despedida() {
		System.out.println(TEXTO_VERDE + "Gracias por usar ALKEMY WALLET");
		System.out.println("********Vuelve pronto*********" + CERRAR_COLOR);
	}

	// Método para obtener la opción seleccionada por el usuario después de una
	// transacción exitosa
	public byte pieTransaccionExitosa() {
		byte opcion = 0;
		boolean entradaValida = false;
		// Ciclo do-while para validar la entrada del usuario
		do {
			try {
				// Mostrar opciones después de una transacción exitosa
				System.out.println("¿Desea realizar otra operación?");
				System.out.println("Seleccione (1) para SI");
				System.out.println("Seleccione (2) para TERMINAR Y SALIR");
				opcion = scanner.nextByte();
				// Validar que la opción esté dentro del rango válido
				if (opcion < 1 || opcion > 2) {
					System.out.println(
							TEXTO_VERDE + "Error: Por favor, seleccione una opción válida (1 o 2)." + CERRAR_COLOR);
					continue; // Volver al inicio del bucle
				}
				entradaValida = true;
			} catch (InputMismatchException e) {
				// Limpiar el buffer del scanner
				scanner.nextLine();
				mensajeDeError("número entero");
			}
		} while (!entradaValida);
		return opcion;
	}

	// Método para mostrar el mensaje de transacción exitosa y obtener la opción del
	// usuario
	public byte transaccionExitosa(String operacion, double monto) {
		// Mostrar mensaje de transacción exitosa
		System.out.println(TEXTO_VERDE + "******TRANSACCION EXITOSA******" + CERRAR_COLOR);
		System.out.println("Se ha realizado un " + operacion);
		System.out.println("En la cuenta: " + cuenta.getNroCuenta());
		System.out.println("Del usuario: " + cuenta.getUsuario());
		System.out.println("Por un monto de: $" + monto);
		// Mostrar el saldo actual de la cuenta
		muestraSaldo();
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
		// Obtener la opción seleccionada por el usuario
		return pieTransaccionExitosa();
	}

	// Otro método para mostrar un mensaje de transacción exitosa (en el caso de
	// transferencias) y obtener la opción del usuario
	public byte transaccionExitosaTransferencia(String operacion, double monto, String cuentaDestino) {
		// Mostrar mensaje de transacción exitosa para transferencias
		System.out.println(TEXTO_VERDE + "******TRANSACCION EXITOSA******" + CERRAR_COLOR);
		System.out.println("Se ha realizado una " + operacion + " a la cuenta " + cuentaDestino);
		System.out.println("por un monto de: $" + monto);
		System.out.println("Desde la cuenta: " + cuenta.getNroCuenta() + " de: " + cuenta.getUsuario());
		// Mostrar el saldo actual de la cuenta
		muestraSaldo();
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
		// Obtener la opción seleccionada por el usuario
		return pieTransaccionExitosa();
	}

	// Método para mostrar el saldo actual de la cuenta
	public void muestraSaldo() {
		System.out.println("SALDO ACTUAL: $" + cuenta.getSaldo() + "\u001B[0m");
	}

	// Método para mostrar el menú de conversión de monedas y obtener la opción del
	// usuario
	public double menuTipoConversion() {
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
		System.out.println("DESEA CONVERTIR UN MONTO DISTINTO?:");
		System.out.println("Seleccione (1) para SI");
		System.out.println("Seleccione (2) para IR AL MENU INICIAL");
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
		byte opcion = scanner.nextByte();

		if (opcion == 1) {
			// Si el usuario elige convertir un monto distinto, solicitar el monto
			System.out.println("Escriba el monto que desea convertir:");
			double monto = scanner.nextDouble();
			return monto;
		} else {
			// Si el usuario elige volver al menú inicial, permitirle seleccionar otra
			// operación
			cuenta.seleccionarOperacion();
			return 0;
		}
	}

	// Método para mostrar los datos de la cuenta
	public void mostrarDatosCuenta() {
		// Mostrar los datos de la cuenta
		System.out.println(TEXTO_VERDE + "******DATOS DE LA CUENTA******" + CERRAR_COLOR);
		System.out.println("Nombre usuario: " + cuenta.getUsuario());
		System.out.println("RUT: " + cuenta.getRut());
		System.out.println("Número de cuenta: " + cuenta.getNroCuenta());
		System.out.println("Saldo actual: $" + cuenta.getSaldo());
		System.out.println(TEXTO_VERDE + "********************************" + CERRAR_COLOR);
	}

	// Método para mostrar un mensaje de fondos insuficientes
	public void fondosInsuficientes() {
		System.err.println(MENSAJE_ERROR + "Error: Fondos insuficientes");
		System.out.println("Su saldo actual es de: " + cuenta.getSaldo());
		System.out.println("Debe realizar un depósito o seleccionar otra operación" + CERRAR_COLOR);
	}

	// Método para solicitar la cuenta destino en una transferencia
	public String solicitaCuentaDestino() {
		String cuentaDestino = "";
		boolean entradaValida = false;
		do {
			try {
				if (cuentaDestino.isEmpty()) {
					scanner.nextLine();
				}
				System.out.println("Ingrese el número de cuenta destino: ");
				cuentaDestino = scanner.nextLine();
				if (cuentaDestino.isEmpty() || !cuentaDestino.matches("[0-9]+")) {
					throw new InputMismatchException();
				}
				entradaValida = true;
			} catch (InputMismatchException e) {
				mensajeDeError("número de cuenta");
			}

		} while (!entradaValida);
		return cuentaDestino;
	}

	// Método para solicitar al usuario el monto de una operación (depósito, retiro,
	// etc.)
	public double solicitaDatosAUsuario(String tipoOperacion) {
		double monto = 0;
		boolean entradaValida = false;

		while (!entradaValida) {
			try {
				// Solicitar al usuario el monto de la operación
				System.out.println("Ingrese el monto de " + tipoOperacion + ":");
				monto = scanner.nextDouble();

				// Validar la entrada del monto
				if (monto <= 0) {
					throw new InputMismatchException();
				}

				entradaValida = true;
			} catch (InputMismatchException e) {
				mensajeDeError("monto");
				scanner.next();
			}
		}

		return monto;
	}

	// Método para mostrar un mensaje de error al usuario
	private void mensajeDeError(String datoSolicitado) {
		System.out
				.println(MENSAJE_ERROR + "Error: Por favor, ingrese un " + datoSolicitado + " válido." + CERRAR_COLOR);
	}
}
