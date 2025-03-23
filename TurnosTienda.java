// Aplicación TDA cola


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TurnosTienda {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);  // Scanner para leer entrada del usuario

        // Cola para manejar a los clientes en orden FIFO (First In, First Out)
        Queue<String> colaTurnos = new LinkedList<>();

        boolean activo = true;  // Control del ciclo principal

        while (activo) {
            // Muestra el menú interactivo en cada iteración
			System.out.println("   ╠════════════════════════════════╣");
            System.out.println("   ║        Menú de Atención        ║ ");
            System.out.println("   ╠════════════════════════════════╣");
            System.out.println("   ║ 1. Llegar cliente              ║");
            System.out.println("   ║ 2. Atender siguiente           ║");
            System.out.println("   ║ 3. Mostrar fila actual         ║");
            System.out.println("   ║ 4. Salir del sistema           ║");
            System.out.println("   ╚════════════════════════════════╝");
            System.out.print("Seleccione una opción (1-4): ");

            String opcion = teclado.nextLine().trim();  

            switch (opcion) {

                // Agregar cliente a la cola
                case "1":
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nuevoCliente = teclado.nextLine().trim();

                    if (!nuevoCliente.isEmpty()) {
                        colaTurnos.offer(nuevoCliente);  // Agrega al final de la cola
                        System.out.println("Cliente '" + nuevoCliente + "' agregado a la fila.");
                    } else {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                    break;

                // Atender al cliente
                case "2":
                    if (colaTurnos.isEmpty()) {
                        System.out.println("No hay clientes para atender.");
                    } else {
                        String clienteAtendido = colaTurnos.poll();  // Elimina el primero
                        System.out.println("Atendiendo a: " + clienteAtendido);
                    }
                    break;

                // Mostrar estado actual de la fila
                case "3":
                    if (colaTurnos.isEmpty()) {
                        System.out.println("La fila está vacía.");
                    } else {
                        System.out.println("Clientes en espera:");
                        for (String cliente : colaTurnos) {
                            System.out.println("- " + cliente);
                        }
                    }
                    break;

                // Salir del programa
                case "4":
                    System.out.println("Cerrando el sistema de atención... ¡Hasta pronto!");
                    activo = false;
                    break;

                // Si en dado caso la opción no fuera válida...
                default:
                    System.out.println("❗ Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        teclado.close(); 
    }
}
