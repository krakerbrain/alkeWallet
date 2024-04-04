package clases;

public class TransaccionFactory {
	public Operacion obtenerOperacion(Cuenta cuenta, int opcion) {
		switch (opcion) {
		case 1:
			return new Deposito(cuenta);
		case 2:
			return new Retiro(cuenta);
		case 3:
			return new Transferencia(cuenta);
		case 4:
			return new ConvertirMoneda(cuenta);
		case 5:
			return new Consulta(cuenta);
		default:
			return null;
		}
	}

}
