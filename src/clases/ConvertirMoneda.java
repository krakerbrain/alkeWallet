package clases;



public class ConvertirMoneda implements Operacion {
	private Cuenta cuenta;


	/**
	 * 
	 */
	public ConvertirMoneda(Cuenta cuenta) {
		this.cuenta = cuenta;

	}

	@Override
	public void ejecutarTransaccion(Menu menu) {

		Double monto = null;
		convierteMoneda(menu,monto);
		
	}
	
	public void convierteMoneda(Menu menu,Double monto) {
		double montoAConvertir;
		String saldoOMonto;

		
		if(monto != null) {
			montoAConvertir = monto;
			saldoOMonto = "MONTO";
		}else {
			montoAConvertir = cuenta.getSaldo();
			saldoOMonto = "SALDO";
		}
        // Crear instancias de cada tipo de moneda con sus tasas de cambio
        Moneda peso = new Moneda("PESO", "CLP ", 1.0, saldoOMonto, montoAConvertir);
        Moneda dolar = new Moneda("DOLAR", "USD ", 979.76, saldoOMonto, montoAConvertir); // Reemplazar con la tasa real
        Moneda euro = new Moneda("EURO", "EUR ", 1058.19, saldoOMonto, montoAConvertir); // Reemplazar con la tasa real

        Moneda[] arregloMonedas = {peso, dolar, euro};
        
        for (Moneda moneda : arregloMonedas) {
			moneda.show();
		}
        monto = menu.menuTipoConversion();
        if(monto != 0) {        	
        	convierteMoneda(menu, monto);
        }
	}
}
