package clases;

//Clase Consulta implementa la interfaz Operacion
public class Consulta implements Operacion {
 // Atributo cuenta para almacenar la cuenta asociada a la consulta
 private Cuenta cuenta;

 // Constructor de la clase Consulta que recibe una cuenta como parámetro
 public Consulta(Cuenta cuenta) {
     this.cuenta = cuenta;
 }

 // Método ejecutarTransaccion implementado de la interfaz Operacion
 @Override
 public void ejecutarTransaccion(Menu menu) {
     // Mostrar los datos de la cuenta utilizando el menú proporcionado
     menu.mostrarDatosCuenta();
     // Solicitar al usuario si desea realizar otra operación
     byte opcion = menu.pieTransaccionExitosa();

     // Verificar la opción seleccionada por el usuario
     if (opcion == 1) {
         // Si la opción es 1, volver a seleccionar una operación en la cuenta
         cuenta.seleccionarOperacion();
     } else {
         // Si la opción es distinta de 1, despedirse y finalizar el programa
         menu.despedida();
     }
 }
}
