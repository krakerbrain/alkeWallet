package clases;

import java.util.Random; // Importación de la clase Random

//Clase que representa una cuenta bancaria
public class Cuenta {
	// Atributos de la cuenta
	private String usuario;
	private String rut;
	private int nroCuenta;
	private double saldo;
	private Menu menu; // Menú asociado a la cuenta

	// Constructor vacío
	public Cuenta() {
		this.menu = new Menu(this); // Inicializa el menú asociado a la cuenta
	}

	// Constructor con parámetros
	public Cuenta(String usuario, String rut, int nroCuenta, double saldo) {
		this.usuario = usuario;
		this.rut = rut;
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
	}

	// Métodos getter y setter para los atributos de la cuenta

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	// Método para generar un número de cuenta aleatorio
	public int generaNumeroCuenta() {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(90000000) + 10000000; // Genera un número aleatorio de 8 dígitos
		return numeroAleatorio;
	}

	// Método para seleccionar una operación bancaria
	public void seleccionarOperacion() {
		int opcion = menu.menuPpal(); // Obtiene la opción seleccionada del menú
		TransaccionFactory transaccionFactory = new TransaccionFactory(); // Crea una fábrica de transacciones
		Operacion operacion = transaccionFactory.obtenerOperacion(this, opcion); // Obtiene la operación correspondiente

		// Verifica si se obtuvo una operación válida
		if (operacion != null) {
			operacion.ejecutarTransaccion(menu); // Ejecuta la transacción seleccionada
		} else {
			menu.despedida(); // Si no se obtuvo una operación válida, muestra el mensaje de despedida
		}
	}

	// Método para revisar si hay saldo suficiente en la cuenta para una operación
	public boolean revisaSaldo(double monto) {
		if (saldo < monto) { // Verifica si el saldo es menor que el monto de la operación
			menu.fondosInsuficientes(); // Muestra el mensaje de fondos insuficientes
			seleccionarOperacion(); // Permite al usuario seleccionar otra operación
			return false;
		}
		return true;
	}
}
