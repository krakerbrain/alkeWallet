package clases;

import java.util.Random;

public class Cuenta {
	protected String usuario;
	protected String rut;
	protected int nroCuenta;
	protected double saldo;
	private Menu menu;

	/**
	 * Constructor vacío
	 */
	public Cuenta() {
		this.menu = new Menu(this);
	}



	/**
	 * @param usuario
	 * @param rut
	 */
	public Cuenta(String usuario, String rut, int nroCuenta, double saldo) {
		this.usuario = usuario;
		this.rut = rut;
		this.nroCuenta = nroCuenta;
		this.saldo = saldo;
	}
	/**
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the rut
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * @param rut the rut to set
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * @return the nroCuenta
	 */
	public int getNroCuenta() {
		return nroCuenta;
	}

	/**
	 * @param string the nroCuenta to set
	 */
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public int generaNumeroCuenta() {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(90000000) + 10000000; // Genera un número aleatorio de 8 dígitos
		return numeroAleatorio;
	}

	public void seleccionarOperacion() {
		int opcion = menu.menuPpal();
		// Se usa el patrón factory para crear clase que instancia las transacciones
		TransaccionFactory transaccionFactory = new TransaccionFactory();
		// Se crea instancia de operacion para luego usar el metodo
		// ejecutarTransaccion en cualquiera de las operaciones
		Operacion operacion = transaccionFactory.obtenerOperacion(this, opcion);

		if (operacion != null) {
			operacion.ejecutarTransaccion(menu);
		} else {
			menu.despedida();
		}
	}

	public boolean revisaSaldo(double monto) {
		if (saldo < monto) {
			menu.fondosInsuficientes();
			seleccionarOperacion();
			return false;
		}
		return true;
	}

}
