package clases;

import java.text.DecimalFormat;

public class Moneda {
	private String moneda;
	 private String simbolo;
	 private double tasaDeCambio;
	 private String montoOSaldo;
	 private double monto;
	 private String cambio;
	 DecimalFormat formato = new DecimalFormat("#,###.00");

	    public Moneda(String moneda, String simbolo, double tasaDeCambio, String montoOSaldo, double monto) {
	    	this.moneda = moneda;
	        this.simbolo = simbolo;
	        this.tasaDeCambio = tasaDeCambio;
	        this.montoOSaldo = montoOSaldo;
	        this.monto = monto;
	        
	    }

	    public String getSimbolo() {
	        return simbolo;
	    }

	    public void convertir() {
	        cambio = formato.format(monto / tasaDeCambio);
	    }
	    
	    public void show() {
	    	convertir();
	    	 System.out.println(montoOSaldo + " EN " + moneda+" " + simbolo + cambio);
		}
}
