package clases;

import java.text.DecimalFormat;

//Clase Moneda para representar una moneda y realizar conversiones
public class Moneda {
	// Atributos de la clase
	private String moneda;
	private String simbolo;
	private double tasaDeCambio;
	private String montoOSaldo;
	private double monto;
	private String cambio;
	DecimalFormat formato = new DecimalFormat("#,###.00"); // Formato para el monto convertido

	// Constructor de la clase
	public Moneda(String moneda, String simbolo, double tasaDeCambio, String montoOSaldo, double monto) {
		this.moneda = moneda;
		this.simbolo = simbolo;
		this.tasaDeCambio = tasaDeCambio;
		this.montoOSaldo = montoOSaldo;
		this.monto = monto;
	}

	// Método para obtener el símbolo de la moneda
	public String getSimbolo() {
		return simbolo;
	}

	// Método para realizar la conversión del monto a la moneda deseada
	public void convertir() {
		cambio = formato.format(monto / tasaDeCambio); // Calcula el monto convertido
	}

	// Método para mostrar el monto convertido
	public void show() {
		convertir(); // Realiza la conversión antes de mostrar el monto
		System.out.println(montoOSaldo + " EN " + moneda + " " + simbolo + cambio); // Muestra el monto convertido
	}
}
