package alkeWallet;

import java.util.Scanner;

import clases.Cuenta;

public class Main {
	public static void main(String[] args) {
		Cuenta cuenta = bienvenida();
		cuenta.seleccionarOperacion();
	}
	
	private static Cuenta bienvenida() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\u001B[32m******Bienvenido a Alkewallet*******");
		System.out.println("------------------------------------\u001B[0m");
		System.out.println("Para comenzar debes crear una cuenta");

		System.out.println("Ingresa tu rut:");
		String rut = scanner.nextLine();

		System.out.println("Ingresa tu nombre:");
		String usuario = scanner.nextLine();

		return creaCuenta(rut,usuario);
	}
	
	public static Cuenta creaCuenta(String rut,String usuario) {
		// Crear instancia de la cuenta
		Cuenta cuenta = new Cuenta();
		cuenta.setRut(rut);
		cuenta.setUsuario(usuario);
		cuenta.setNroCuenta(cuenta.generaNumeroCuenta());
		cuenta.setSaldo(0);
		return cuenta;
	}

}
